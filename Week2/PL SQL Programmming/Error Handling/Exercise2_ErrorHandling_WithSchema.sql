
-- ErrorLog Table for Logging Errors
CREATE TABLE ErrorLog (
    LogID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ErrorMessage VARCHAR2(4000),
    ErrorTime DATE DEFAULT SYSDATE
);

-- Procedure 1: SafeTransferFunds
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account NUMBER,
    p_to_account NUMBER,
    p_amount NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for transfer.');
    END IF;

    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog(ErrorMessage) VALUES ('Transfer failed: ' || SQLERRM);
END;
/

-- Procedure 2: UpdateSalary
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_emp_id NUMBER,
    p_percent NUMBER
) IS
    v_salary NUMBER;
BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_emp_id;

    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_emp_id;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        INSERT INTO ErrorLog(ErrorMessage) VALUES ('Employee not found for ID: ' || p_emp_id);
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog(ErrorMessage) VALUES ('Salary update failed: ' || SQLERRM);
END;
/

-- Procedure 3: AddNewCustomer
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_id NUMBER,
    p_name VARCHAR2,
    p_dob DATE,
    p_balance NUMBER
) IS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        INSERT INTO ErrorLog(ErrorMessage) VALUES ('Duplicate CustomerID: ' || p_id);
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog(ErrorMessage) VALUES ('Add customer failed: ' || SQLERRM);
END;
/
