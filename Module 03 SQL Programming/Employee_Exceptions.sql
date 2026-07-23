SET SERVEROUTPUT ON;
DECLARE
    v_name employee_details.emp_name%TYPE;
BEGIN
    SELECT emp_name
    INTO v_name
    FROM employee_details
    WHERE emp_id = 999;
    DBMS_OUTPUT.PUT_LINE(v_name);
EXCEPTION
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('Employee not found.');
END;
