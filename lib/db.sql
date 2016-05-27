#database

/*  BEGINING */
CREATE TABLE HQ
(
id_hq INT PRIMARY KEY NOT NULL,
hq_first_name VARCHAR2(100),
city VARCHAR2(100),
zip_code VARCHAR2(100),
address VARCHAR2(100)
);

CREATE TABLE AGENCY
(
id_agency INT PRIMARY KEY NOT NULL,
id_hq INT,
agency_name VARCHAR2(100),
city VARCHAR2(100),
zip_code VARCHAR2(100),
tel_num VARCHAR2(100),
id_responsable INT NOT NULL,
FOREIGN KEY (id_hq) REFERENCES HQ(id_hq) ON DELETE CASCADE
);

CREATE TABLE EMPLOYEE
(
id_employee INT PRIMARY KEY NOT NULL,
id_agency INT,
employee_first_name VARCHAR2(100),
employee_last_name VARCHAR2(100),
employee_email VARCHAR2(100),
tel_num VARCHAR2(100),
FOREIGN KEY (id_agency) REFERENCES AGENCY(id_agency) ON DELETE CASCADE
);

CREATE TABLE CLIENT
(
id_client INT PRIMARY KEY NOT NULL,
id_employee INT,
age INT,
client_first_name VARCHAR2(100),
client_last_name VARCHAR2(100),
client_email VARCHAR2(100),
tel_num VARCHAR2(100),
client_city VARCHAR2(100),
address VARCHAR2(100),
zip_code VARCHAR2(100),
salary VARCHAR2(10),
charge VARCHAR2(10),
debtRate VARCHAR2(5),
FOREIGN KEY (id_employee) REFERENCES EMPLOYEE(id_employee) ON DELETE CASCADE
);


CREATE TABLE LOAN_TYPE
(
id_loan_type INT PRIMARY KEY NOT NULL,
loan_name VARCHAR2(100),
rate FLOAT,
);

CREATE TABLE HISTORY
(
id_history INT PRIMARY KEY NOT NULL,
id_loan INT,
change_date DATE
);

CREATE TABLE LOAN
(
id_loan INT PRIMARY KEY NOT NULL,
id_client INT,
id_conseiller INT,
id_loan_type INT,
id_history INT,
asked_amount INT,
asked_duration INT,
asked_rate FLOAT,
asked_rateInsurance FLOAT,
asked_date DATE,
decision INT,
FOREIGN KEY (id_loan_type) REFERENCES LOAN_TYPE(id_loan_type) ON DELETE CASCADE,
FOREIGN KEY (id_client) REFERENCES CLIENT(id_client) ON DELETE CASCADE,
FOREIGN KEY (id_conseiller) REFERENCES EMPLOYEE(id_employee) ON DELETE CASCADE,
FOREIGN KEY (id_history) REFERENCES HISTORY(id_history) ON DELETE CASCADE
);

CREATE TABLE ACCOUNT
(
id_account INT PRIMARY KEY NOT NULL,
id_client INT,
open_date DATE,
balance INT,
FOREIGN KEY (id_client) REFERENCES CLIENT(id_client) ON DELETE CASCADE
);

CREATE TABLE RATE
(
id_rate INT PRIMARY KEY NOT NULL,
rate_value FLOAT,
rate_type VARCHAR2(100),
rate_agency FLOAT,
rate_duration INT
);

CREATE TABLE RATE_HISTORY
(
id_rate_history INT PRIMARY KEY NOT NULL,
id_rate INT,
rate_value INT,
change_date DATE,
FOREIGN KEY (id_rate) REFERENCES RATE(id_rate)
);

CREATE SEQUENCE  seq_client_ai  MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

CREATE SEQUENCE  seq_agency_ai  MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

CREATE SEQUENCE  seq_account_ai  MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

CREATE SEQUENCE  seq_employee_ai  MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

CREATE SEQUENCE  seq_hq_ai  MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

CREATE SEQUENCE  seq_loan_ai  MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

CREATE SEQUENCE  seq_loan_type_ai  MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

CREATE SEQUENCE  seq_history_ai  MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

CREATE SEQUENCE  seq_rate_ai  MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

CREATE SEQUENCE  seq_rate_history_ai  MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

create or replace TRIGGER tr_agency_ai
BEFORE INSERT ON AGENCY
FOR EACH ROW
BEGIN
SELECT seq_agency_ai.nextval INTO :NEW.id_agency FROM dual;
END ;
/
create or replace TRIGGER tr_client_ai
BEFORE INSERT ON CLIENT
FOR EACH ROW
BEGIN
SELECT seq_client_ai.nextval INTO :NEW.id_client FROM dual;
END ;
/
create or replace TRIGGER tr_account_ai
BEFORE INSERT ON ACCOUNT
FOR EACH ROW
BEGIN
SELECT seq_account_ai.nextval INTO :NEW.id_account FROM dual;
END ;
/
create or replace TRIGGER tr_employee_ai
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
SELECT seq_employee_ai.nextval INTO :NEW.id_employee FROM dual;
END ;
/
create or replace TRIGGER tr_history_ai
BEFORE INSERT ON HISTORY
FOR EACH ROW
BEGIN
SELECT seq_history_ai.nextval INTO :NEW.id_history FROM dual;
END ;
/
create or replace TRIGGER tr_rate_history_ai
BEFORE INSERT ON RATE_HISTORY
FOR EACH ROW
BEGIN
SELECT seq_rate_history_ai.nextval INTO :NEW.id_rate_history FROM dual;
END ;
/
create or replace TRIGGER tr_hq_ai
BEFORE INSERT ON HQ
FOR EACH ROW
BEGIN
SELECT seq_hq_ai.nextval INTO :NEW.id_hq FROM dual;
END ;
/
create or replace TRIGGER tr_loan_ai
BEFORE INSERT ON LOAN
FOR EACH ROW
BEGIN
SELECT seq_loan_ai.nextval INTO :NEW.id_loan FROM dual;
END ;
/
create or replace TRIGGER tr_rate_ai
BEFORE INSERT ON RATE
FOR EACH ROW
BEGIN
SELECT seq_rate_ai.nextval INTO :NEW.id_rate FROM dual;
END ;
/
create or replace TRIGGER tr_loan_type_ai
BEFORE INSERT ON LOAN_TYPE
FOR EACH ROW
BEGIN
SELECT seq_loan_type_ai.nextval INTO :NEW.id_loan_type FROM dual;
END ;
