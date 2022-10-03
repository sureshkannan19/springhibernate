CREATE TABLE MYDB.`PRODUCT`
(
   `PRODUCT_ID` int PRIMARY KEY NOT NULL,
   `NAME` varchar (20) DEFAULT NULL,
   `DESC` varchar (100) DEFAULT NULL,
   `PRICE` decimal
   (
      8,
      3
   )
   DEFAULT NULL
);
CREATE TABLE MYDB.`EMPLOYEE`
(
   `EMP_ID` int PRIMARY KEY,
   `NAME` varchar (20) DEFAULT NULL
);
CREATE TABLE MYDB.ID_GENERATOR
(
   GEN_NAME varchar (60) PRIMARY KEY,
   GEN_VAL int not null
);
create table mydb.BANKACCOUNT
(
   ACC_NUM int primary key auto_increment,
   LAST_NAME varchar (25),
   FIRST_NAME varchar (25),
   BALANCE int
);
create table mydb.PAYMENT
(
   ID int PRIMARY KEY auto_increment,
   P_MODE varchar (2),
   AMOUNT decimal
   (
      8,
      3
   ),
   CARD_NUM varchar (20),
   CHECK_NUM varchar (20)
);
create table TATA_NEXON
(
   REGISTER_ID VARCHAR (20) PRIMARY KEY,
   FUEL_TYPE varchar (15),
   PRICE_PER_UNIT DECIMAL
   (
      8,
      3
   )
);
create table MARUTHI_SWIFT
(
   REGISTER_ID VARCHAR (20) PRIMARY KEY,
   FUEL_TYPE varchar (15),
   PRICE_PER_LITRE DECIMAL
   (
      8,
      3
   )
);
create table STUDENT
(
   ID INT PRIMARY KEY AUTO_INCREMENT,
   NAME varchar (25)
);
create table BOYZ
(
   ID INT,
   NO_OF_SUBJECTS_FAILED INT,
   FOREIGN KEY (id) REFERENCES STUDENT (id)
);
create table GIRLZ
(
   ID INT,
   NO_OF_SUBJECTS_PASSED INT,
   FOREIGN KEY (id) REFERENCES STUDENT (id)
);
create table customer
(
   id int primary key auto_increment,
   name varchar (20),
   street_address varchar (30),
   city varchar (20),
   state varchar (20),
   zip_code varchar (20),
   country varchar (20)
);