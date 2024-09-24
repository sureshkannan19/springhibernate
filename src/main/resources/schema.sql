CREATE TABLE IF NOT EXISTS `PRODUCT`
(
   `PRODUCT_ID` int PRIMARY KEY,
   `NAME` varchar (20) DEFAULT NULL,
   `DESCRIPTION` varchar (100) DEFAULT NULL,
   `PRICE` decimal
   (
      8,
      3
   )
   DEFAULT NULL
);
CREATE TABLE IF NOT EXISTS `EMPLOYEE`
(
   `EMP_ID` int PRIMARY KEY,
   `NAME` varchar (20) DEFAULT NULL
);
CREATE TABLE IF NOT EXISTS MY_SEQUENCES
(
   SEQ_NAME varchar (60) PRIMARY KEY,
   NEXT_VAL int not null
);
CREATE TABLE IF NOT EXISTS bank_account
(
   ACC_NUM int primary key auto_increment,
   LAST_NAME varchar (25),
   FIRST_NAME varchar (25),
   BALANCE decimal
   (
      8,
      3
   )
);
CREATE TABLE IF NOT EXISTS PAYMENT
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
CREATE TABLE IF NOT EXISTS TATA_NEXON
(
   REGISTER_ID VARCHAR (20) PRIMARY KEY,
   FUEL_TYPE varchar (15),
   PRICE_PER_UNIT DECIMAL
   (
      8,
      3
   )
);
CREATE TABLE IF NOT EXISTS MARUTHI_SWIFT
(
   REGISTER_ID VARCHAR (20) PRIMARY KEY,
   FUEL_TYPE varchar (15),
   PRICE_PER_LITRE DECIMAL
   (
      8,
      3
   )
);
CREATE TABLE IF NOT EXISTS STUDENT
(
   ID INT PRIMARY KEY AUTO_INCREMENT,
   NAME varchar (25)
);
CREATE TABLE IF NOT EXISTS BOYZ
(
   ID INT,
   NO_OF_SUBJECTS_FAILED INT,
   FOREIGN KEY (id) REFERENCES STUDENT (id)
);
CREATE TABLE IF NOT EXISTS GIRLZ
(
   ID INT,
   NO_OF_SUBJECTS_PASSED INT,
   FOREIGN KEY (id) REFERENCES STUDENT (id)
);
CREATE TABLE IF NOT EXISTS customer
(
   id int primary key auto_increment,
   name varchar (20),
   street_address varchar (30),
   city varchar (20),
   state varchar (20),
   zip_code varchar (20),
   country varchar (20)
);
CREATE TABLE IF NOT EXISTS User_client
(
   client_id int PRIMARY KEY AUTO_INCREMENT,
   client_name varchar (20)
);
CREATE TABLE IF NOT EXISTS phone_number
(
   id int primary KEY AUTO_INCREMENT,
   client_id int,
   number int,
   type varchar (20),
   FOREIGN KEY (client_id) REFERENCES User_client (client_id)
);
create table if not exists programmer
(
   id int PRIMARY KEY AUTO_INCREMENT,
   name varchar (20)
);
create table if not exists project
(
   id int PRIMARY KEY AUTO_INCREMENT,
   name varchar (20)
);
create table if not exists programmers_projects
(
   programmer_id int,
   project_id int,
   FOREIGN KEY (programmer_id) REFERENCES programmer (id),
   FOREIGN KEY (project_id) REFERENCES project (id)
);
create table if not exists person
(
   id int PRIMARY KEY AUTO_INCREMENT,
   first_name varchar (20),
   last_name varchar (20),
   age int
);
create table if not exists license
(
   id int PRIMARY KEY AUTO_INCREMENT,
   type varchar (20),
   valid_from date,
   valid_to date,
   person_id int,
   FOREIGN KEY (person_id) REFERENCES person (id)
);
create table if not exists ICCRanking
(
   team_name varchar (20) PRIMARY KEY,
   ranking int,
   match_format varchar (20)
);
create table if not exists PLAYER
(
   PLAYER_NAME varchar (20) PRIMARY KEY,
   TEAM_NAME varchar (20),
   T20_RANKING int,
   ODI_RANKING int,
   TEST_RANKING int
);
create table if not exists ICCRanking_AUD
(
   team_name varchar (20),
   ranking int,
   match_format varchar (20),
   rev bigint,
   revtype varchar (20)
);
create table if not exists PLAYER_AUD
(
   PLAYER_NAME varchar (20),
   TEAM_NAME varchar (20),
   T20_RANKING int,
   ODI_RANKING int,
   TEST_RANKING int,
   rev bigint,
   revtype varchar (20)
);
create table if not exists REVINFO
(
   rev bigint not null primary key AUTO_INCREMENT,
   revtstmp timestamp
);
create table if not exists CRIC_MATCH
(
   MATCH_FORMAT varchar (20),
   NO_OF_OVERS int
);
create TABLE if not exists image
(
   id BIGINT NOT NULL,
   name varchar (100) NOT NULL,
   data BLOB NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS customers
(
   customer_Id int primary key auto_increment,
   customer_Name varchar (20),
   social_Security_Num varchar (30),
   PAYMENT_MODE varchar (30)
);


CREATE TABLE IF NOT EXISTS customers_aud
(
   customer_Id int primary key auto_increment,
   customer_Name varchar (20),
   social_Security_Num varchar (30),
   PAYMENT_MODE varchar (30),
   rev bigint,
   revtype varchar (20)
);

CREATE TABLE IF NOT EXISTS payments
(
    PAYMENT_MODE varchar (30),
   ACCEPTABLE_COUNTRY varchar (30)
);

CREATE TABLE IF NOT EXISTS SHOP_OWNER
(
    SHOP_NAME varchar (30),
   OWNER_id int primary key
);