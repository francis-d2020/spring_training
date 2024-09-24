INSERT INTO EMPLOYEES(id,name)
VALUES(1,'Mike');

/*
INSERT INTO students(id,first_name,last_name,email)
VALUES(1,'Mike','Smith','mike@cydeo.com');

 */
-- unlike the previous query, the id is given from the sql(by postgres)
INSERT INTO students(first_name,last_name,email)
VALUES('Mike','Smith','mike@cydeo.com');

INSERT INTO students(first_name,last_name,email)
VALUES('Tom','Hanks','tom@cydeo.com');