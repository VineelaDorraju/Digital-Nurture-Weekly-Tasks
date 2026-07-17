SET SERVEROUTPUT ON;
DECLARE
    CURSOR emp_cur IS SELECT emp_name, salary
        FROM employee_details;
    v_name employee_details.emp_name%TYPE;
    v_salary employee_details.salary%TYPE;
BEGIN
    OPEN emp_cur;
  LOOP
        FETCH emp_cur INTO v_name, v_salary;
        EXIT WHEN emp_cur%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_name || ' : ' || v_salary);
    END LOOP;
    CLOSE emp_cur;
END;
