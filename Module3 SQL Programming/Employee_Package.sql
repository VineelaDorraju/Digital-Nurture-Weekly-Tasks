SET SERVEROUTPUT ON;
CREATE OR REPLACE PACKAGE employee_pkg AS
    PROCEDURE show_name(p_id NUMBER);
    FUNCTION get_department(p_id NUMBER) RETURN VARCHAR2;
END employee_pkg;
/
CREATE OR REPLACE PACKAGE BODY employee_pkg AS
    PROCEDURE show_name(p_id NUMBER) IS
        v_name employee_details.emp_name%TYPE;
    BEGIN
        SELECT emp_name
        INTO v_name
        FROM employee_details
        WHERE emp_id = p_id;
        DBMS_OUTPUT.PUT_LINE('Employee : ' || v_name);
    END;
    FUNCTION get_department(p_id NUMBER)
    RETURN VARCHAR2 IS v_dept employee_details.department%TYPE;
    BEGIN
        SELECT department
        INTO v_dept
        FROM employee_details
        WHERE emp_id = p_id;
        RETURN v_dept;
      END;
END employee_pkg;
/
BEGIN
    employee_pkg.show_name(102);
    DBMS_OUTPUT.PUT_LINE('Department : ' ||
        employee_pkg.get_department(102));
END;
