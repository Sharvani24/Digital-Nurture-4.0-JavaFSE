
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

-- CustomerManagement Package
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
    END;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name, DOB = p_dob, Balance = p_balance, LastModified = SYSDATE
        WHERE CustomerID = p_id;
    END;

    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    END;
END CustomerManagement;
/

-- EmployeeManagement Package
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2);
    PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2);
    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2) IS
    BEGIN
        INSERT INTO Employees(EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_id, p_name, p_position, p_salary, p_department, SYSDATE);
    END;

    PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_department VARCHAR2) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name, Position = p_position, Salary = p_salary, Department = p_department
        WHERE EmployeeID = p_id;
    END;

    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    END;
END EmployeeManagement;
/

-- AccountOperations Package
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_account_id NUMBER, p_customer_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_account_id NUMBER);
    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_account_id NUMBER, p_customer_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts(AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_type, p_balance, SYSDATE);
    END;

    PROCEDURE CloseAccount(p_account_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_account_id;
    END;

    FUNCTION GetTotalBalance(p_customer_id NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_customer_id;
        RETURN v_total;
    END;
END AccountOperations;
/

