# product-billing-app
This Project is used to control and maintain the accountant salary and students personal and payment details. Technology used to make this project: - JavaScript, Java, HTML, CSS, Servlets, JDBC, MySQL.

User has to create 2 tables as query given below:-
CREATE TABLE "FEE_STUDENT" ("ROLLNO" VARCHAR2(4000), "NAME" VARCHAR2(4000), "EMAIL" VARCHAR2(4000), "SEX" VARCHAR2(4000), "COURSE" VARCHAR2(4000), "FEE" NUMBER, "PAID" NUMBER, "DUE" NUMBER, "ADDRESS" VARCHAR2(4000), "CONTACT" VARCHAR2(4000), CONSTRAINT "FEE_STUDENT_PK" PRIMARY KEY ("ROLLNO") ENABLE ) /

CREATE TABLE "FEE_ACCOUNTANT" ( "ID" NUMBER, "NAME" VARCHAR2(4000), "EMAIL" VARCHAR2(4000), "PASSWORD" VARCHAR2(4000), "ADDRESS" VARCHAR2(4000), "CONTACT" VARCHAR2(4000), CONSTRAINT "FEE_ACCOUNTANT_PK" PRIMARY KEY ("ID") ENABLE ) /
