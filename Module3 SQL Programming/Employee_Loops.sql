SET SERVEROUTPUT ON;
BEGIN
    FOR emp IN (
        SELECT emp_name,department
        FROM employee_details
        ORDER BY emp_id
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(emp.emp_name || ' - ' || emp.department);
    END LOOP;
END;
