SET SERVEROUTPUT ON;
CREATE OR REPLACE FUNCTION get_salary (
    p_id IN NUMBER
)
RETURN NUMBER
AS v_salary employee_details.salary%TYPE;
BEGIN
    SELECT salary
    INTO v_salary
    FROM employee_details
    WHERE emp_id = p_id;
    RETURN v_salary;
END;
/
DECLARE
    v_salary NUMBER;
BEGIN
    v_salary := get_salary(101);
    DBMS_OUTPUT.PUT_LINE('Salary : ' || v_salary);
 END;
