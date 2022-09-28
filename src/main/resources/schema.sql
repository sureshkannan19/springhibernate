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