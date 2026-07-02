SET SERVEROUTPUT ON;
DECLARE emp employee_details%ROWTYPE;
BEGIN
    SELECT *
    INTO emp
    FROM employee_details
    WHERE emp_id = 103;
    DBMS_OUTPUT.PUT_LINE('ID         :' || emp.emp_id);
    DBMS_OUTPUT.PUT_LINE('Name       :' || emp.emp_name);
    DBMS_OUTPUT.PUT_LINE('Department :' || emp.department);
    DBMS_OUTPUT.PUT_LINE('Salary     :' || emp.salary);
  END;
