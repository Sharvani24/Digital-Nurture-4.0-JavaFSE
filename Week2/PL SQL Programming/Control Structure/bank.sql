
-- DROP tables if exist
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Transactions_1 CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Accounts_1 CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Loans_1 CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Employees_1 CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Customers_2 CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

-- Create tables
CREATE TABLE Customers_2 ( 
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts_1 ( 
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers_2(CustomerID)
);

CREATE TABLE Transactions_1 ( 
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts_1(AccountID)
);

CREATE TABLE Loans_1 ( 
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers_2(CustomerID)
);

CREATE TABLE Employees_1 ( 
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- Insert sample data
INSERT INTO Customers_2 VALUES (1, 'John Doe', TO_DATE('1950-01-01', 'YYYY-MM-DD'), 12000, SYSDATE);
INSERT INTO Customers_2 VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 9500, SYSDATE);

INSERT INTO Accounts_1 VALUES (1, 1, 'Savings', 12000, SYSDATE);
INSERT INTO Accounts_1 VALUES (2, 2, 'Checking', 9500, SYSDATE);

INSERT INTO Transactions_1 VALUES (1, 1, SYSDATE, 200, 'Deposit');
INSERT INTO Transactions_1 VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans_1 VALUES (1, 1, 5000, 6.5, SYSDATE, SYSDATE + 15);
INSERT INTO Loans_1 VALUES (2, 2, 7000, 5.5, SYSDATE, SYSDATE + 45);

INSERT INTO Employees_1 VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees_1 VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

-- Add IsVIP column
ALTER TABLE Customers_2 ADD IsVIP VARCHAR2(5);

COMMIT;

-- Create Procedure to Apply Discount for Customers Over 60
CREATE OR REPLACE PROCEDURE apply_discount IS
BEGIN
  FOR cust IN (SELECT CustomerID, Name, DOB FROM Customers_2) LOOP
    IF MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12 > 60 THEN
      UPDATE Loans_1
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = cust.CustomerID;

      DBMS_OUTPUT.PUT_LINE('1% Discount applied for: ' || cust.Name);
    END IF;
  END LOOP;
  COMMIT;
END;
/

-- Create Procedure to Set VIP for High Balance
CREATE OR REPLACE PROCEDURE promote_to_vip IS
BEGIN
  FOR cust IN (SELECT CustomerID, Balance, Name FROM Customers_2) LOOP
    IF cust.Balance > 10000 THEN
      UPDATE Customers_2
      SET IsVIP = 'TRUE'
      WHERE CustomerID = cust.CustomerID;

      DBMS_OUTPUT.PUT_LINE('VIP status set for: ' || cust.Name);
    END IF;
  END LOOP;
  COMMIT;
END;
/

-- Create Procedure to Print Reminders
CREATE OR REPLACE PROCEDURE loan_reminders IS
BEGIN
  FOR loan_rec IN (
    SELECT l.LoanID, c.Name, l.EndDate
    FROM Loans_1 l
    JOIN Customers_2 c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || loan_rec.Name ||
                         ', your loan (ID: ' || loan_rec.LoanID ||
                         ') is due on ' || TO_CHAR(loan_rec.EndDate, 'DD-Mon-YYYY'));
  END LOOP;
END;
/
