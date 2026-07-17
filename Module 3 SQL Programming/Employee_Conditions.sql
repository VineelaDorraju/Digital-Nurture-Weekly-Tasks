SET SERVEROUTPUT ON;
DECLARE
    v_salary employee_details.salary%TYPE;
BEGIN
    SELECT salary
    INTO v_salary
    FROM employee_details
    WHERE emp_id =105;
    IF v_salary>= 50000 THEN DBMS_OUTPUT.PUT_LINE('High Salary');
    ELSIF v_salary >= 40000 THEN DBMS_OUTPUT.PUT_LINE('Medium Salary');
    ELSE DBMS_OUTPUT.PUT_LINE('Low Salary');
    END IF;
  
  END;