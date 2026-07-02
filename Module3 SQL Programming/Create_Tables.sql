CREATE TABLE employee_details (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(50),
    department VARCHAR2(30),
    salary NUMBER(8,2), joining_date DATE
);
CREATE TABLE employee_log (
    log_id NUMBER PRIMARY KEY,
    emp_id NUMBER, action VARCHAR2(50),
    log_date DATE
);