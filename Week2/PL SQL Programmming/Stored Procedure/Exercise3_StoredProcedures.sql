
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

-- Procedure 1: ProcessMonthlyInterest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
END;
/

-- Procedure 2: UpdateEmployeeBonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE Department = dept_name;
END;
/

-- Procedure 3: TransferFunds
CREATE OR REPLACE PROCEDURE TransferFunds (
    source_acc IN NUMBER,
    dest_acc IN NUMBER,
    amount IN NUMBER
) AS
    source_balance NUMBER;
BEGIN
    SELECT Balance INTO source_balance FROM Accounts WHERE AccountID = source_acc FOR UPDATE;

    IF source_balance >= amount THEN
        UPDATE Accounts SET Balance = Balance - amount, LastModified = SYSDATE WHERE AccountID = source_acc;
        UPDATE Accounts SET Balance = Balance + amount, LastModified = SYSDATE WHERE AccountID = dest_acc;

        INSERT INTO Transactions VALUES (3, source_acc, SYSDATE, amount, 'Transfer-Out');
        INSERT INTO Transactions VALUES (4, dest_acc, SYSDATE, amount, 'Transfer-In');
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;
END;
/

-- Test Execution
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Before Interest Update ---');
    FOR r IN (SELECT * FROM Accounts) LOOP
        DBMS_OUTPUT.PUT_LINE('Account ' || r.AccountID || ' Balance: ' || r.Balance);
    END LOOP;

    ProcessMonthlyInterest;

    DBMS_OUTPUT.PUT_LINE('--- After Interest Update ---');
    FOR r IN (SELECT * FROM Accounts) LOOP
        DBMS_OUTPUT.PUT_LINE('Account ' || r.AccountID || ' Balance: ' || r.Balance);
    END LOOP;

    UpdateEmployeeBonus('IT', 10);

    DBMS_OUTPUT.PUT_LINE('--- After Employee Bonus ---');
    FOR e IN (SELECT * FROM Employees) LOOP
        DBMS_OUTPUT.PUT_LINE('Employee ' || e.Name || ' Salary: ' || e.Salary);
    END LOOP;

    TransferFunds(1, 2, 100);

    DBMS_OUTPUT.PUT_LINE('--- After Fund Transfer ---');
    FOR r IN (SELECT * FROM Accounts) LOOP
        DBMS_OUTPUT.PUT_LINE('Account ' || r.AccountID || ' Balance: ' || r.Balance);
    END LOOP;
END;
/