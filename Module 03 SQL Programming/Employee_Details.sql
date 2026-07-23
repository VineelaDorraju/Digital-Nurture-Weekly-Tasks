SET SERVEROUTPUT ON;
DECLARE
    v_name employee_details.emp_name%TYPE;
    v_salary employee_details.salary%TYPE;
BEGIN
    SELECT emp_name, salary
    INTO v_name, v_salary
    FROM employee_details
    WHERE emp_id = 101;
    DBMS_OUTPUT.PUT_LINE('Employee :' || v_name);
    DBMS_OUTPUT.PUT_LINE('Salary   :' || v_salary);
END;
