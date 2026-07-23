SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE show_employee (p_id IN NUMBER)
AS v_name employee_details.emp_name%TYPE;
BEGIN
    SELECT emp_name
    INTO v_name
    FROM employee_details
    WHERE emp_id = p_id;
    DBMS_OUTPUT.PUT_LINE('Employee : ' || v_name);
END;
/
BEGIN
    show_employee(104);
 END;
