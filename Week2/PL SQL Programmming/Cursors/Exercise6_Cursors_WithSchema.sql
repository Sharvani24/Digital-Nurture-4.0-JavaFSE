
-- Schema Creation
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- Sample Data Insertion
INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions VALUES (1, 1, SYSDATE, 200, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

-- Cursor 1: GenerateMonthlyStatements
DECLARE
    CURSOR txn_cursor IS
        SELECT c.CustomerID, c.Name, t.TransactionID, t.Amount, t.TransactionType, t.TransactionDate
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    v_cust_id Customers.CustomerID%TYPE;
    v_name Customers.Name%TYPE;
    v_txn_id Transactions.TransactionID%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_type Transactions.TransactionType%TYPE;
    v_date Transactions.TransactionDate%TYPE;
BEGIN
    OPEN txn_cursor;
    LOOP
        FETCH txn_cursor INTO v_cust_id, v_name, v_txn_id, v_amount, v_type, v_date;
        EXIT WHEN txn_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ', Transaction ID: ' || v_txn_id ||
                             ', Amount: ' || v_amount || ', Type: ' || v_type || ', Date: ' || v_date);
    END LOOP;
    CLOSE txn_cursor;
END;
/

-- Cursor 2: ApplyAnnualFee
DECLARE
    CURSOR acc_cursor IS SELECT AccountID, Balance FROM Accounts;
    v_acc_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_fee CONSTANT NUMBER := 100;
BEGIN
    OPEN acc_cursor;
    LOOP
        FETCH acc_cursor INTO v_acc_id, v_balance;
        EXIT WHEN acc_cursor%NOTFOUND;

        UPDATE Accounts SET Balance = Balance - v_fee, LastModified = SYSDATE WHERE AccountID = v_acc_id;
    END LOOP;
    CLOSE acc_cursor;
    COMMIT;
END;
/

-- Cursor 3: UpdateLoanInterestRates
DECLARE
    CURSOR loan_cursor IS SELECT LoanID, InterestRate FROM Loans;
    v_loan_id Loans.LoanID%TYPE;
    v_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_rate;
        EXIT WHEN loan_cursor%NOTFOUND;

        UPDATE Loans SET InterestRate = v_rate + 0.5 WHERE LoanID = v_loan_id;
    END LOOP;
    CLOSE loan_cursor;
    COMMIT;
END;
/
