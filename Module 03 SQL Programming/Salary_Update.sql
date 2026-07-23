SET SERVEROUTPUT ON;
DECLARE v_emp_id NUMBER := 102;
BEGIN
    UPDATE employee_details
    SET salary = salary + 3000
    WHERE emp_id = v_emp_id;
    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' Employee Updated');
     COMMIT;
  END;
