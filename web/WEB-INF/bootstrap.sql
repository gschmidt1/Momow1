--*************************
--DROP Section 
--*************************
--Drop constraints
ALTER TABLE Users DROP FOREIGN KEY memberid_ref ;
ALTER TABLE Members DROP FOREIGN KEY userid_ref ;

--Drop tables
DROP TABLE Company;
DROP TABLE Services;
DROP TABLE Service_Order;
DROP TABLE Users;
DROP TABLE Members;

--*************************
--CREATE Section 
--*************************
--Create Users Table
CREATE TABLE Users (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    memberid INT,
    --FOREIGN KEY (memberid) REFERENCES MEMBERS(id),
    username VARCHAR(12) NOT NULL UNIQUE,
    password VARCHAR(15) NOT NULL,
    expiration_date DATE,
    create_user_name VARCHAR(20),
    create_date TIMESTAMP,
    change_user_name VARCHAR(20),
    change_date TIMESTAMP
);

--Create Members Table
CREATE TABLE Members (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    userid INT NOT NULL,
    --FOREIGN KEY (userid) REFERENCES USERS(id),
    account_number VARCHAR(20),
    joindate DATE DEFAULT CURRENT_DATE,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    address VARCHAR(40) NOT NULL,
    city VARCHAR(40) NOT NULL,
    st VARCHAR(2) NOT NULL,
    zip VARCHAR(10) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    text_flag SMALLINT DEFAULT 0,
    email VARCHAR(100) NOT NULL,
    expiration_date DATE,
    create_user_name VARCHAR(20),
    create_date TIMESTAMP,
    change_user_name VARCHAR(20),
    change_date TIMESTAMP
);

--Create Service Order Table
CREATE TABLE Service_Order (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    memberid INT NOT NULL,
    FOREIGN KEY (memberid) REFERENCES MEMBERS(id),
    service_group VARCHAR (20),
    service_type_mow VARCHAR (20),
    service_type_edge VARCHAR (20),
    service_type_rake VARCHAR (20),
    instruction VARCHAR(255),
    need_by_date DATE NOT NULL,
    scheduled_date DATE,
    completed_flag SMALLINT DEFAULT 0,
    completed_date DATE,
    expiration_date DATE,
    create_user_name VARCHAR(20),
    create_date TIMESTAMP,
    change_user_name VARCHAR(20),
    change_date TIMESTAMP
);

--Create Services Table
CREATE TABLE Services (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    service_group VARCHAR(20),
    service_group_description VARCHAR(40),
    service_type VARCHAR(20),
    service_type_description VARCHAR(40),
    valueid INT,
    expiration_date DATE,
    create_user_name VARCHAR(20),
    create_date TIMESTAMP,
    change_user_name VARCHAR(20),
    change_date TIMESTAMP
);

--Create Company
CREATE TABLE Company (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    company_name VARCHAR(40),
    address VARCHAR(40),
    city VARCHAR(40),
    st VARCHAR(2),
    zip VARCHAR(10),
    email VARCHAR(60),
    phone VARCHAR(14),
    expiration_date DATE,
    create_user_name VARCHAR(20),
    create_date TIMESTAMP,
    change_user_name VARCHAR(20),
    change_date TIMESTAMP
);

--CREATE foreign keys
ALTER TABLE Users
ADD CONSTRAINT memberid_ref
FOREIGN KEY (memberid) 
REFERENCES Members(id);

ALTER TABLE Members
ADD CONSTRAINT userid_ref  
FOREIGN KEY (userid) 
REFERENCES Users(id);



--INSERT Users
--id auto generated PK
INSERT INTO users
                (memberid, username, password, 
                    expiration_date, create_user_name, create_date, change_user_name, change_date)
                      VALUES(null,'gschmidt','javauser', 
                            null, 'gschmidt', current timestamp, 'gschmidt', current timestamp);

--INSERT Members
--id auto generated PK
--joindate default current date
--text_flag default 0
INSERT INTO members
                (userid, account_number, firstname, lastname, address,
                     city, st, zip, phone, text_flag, email, 
                        expiration_date, create_user_name, create_date, change_user_name, change_date)
                    VALUES(1, 'MM-123', 'Glenn', 'Schmidt', '4813 Gerona Drive',
                             'Austin', 'TX', '78759', '512-947-2264', 0, 'glenn.schmidt@g.austincc.edu', 
                               null, 'gschmidt', current timestamp, 'gschmidt', current timestamp);

--UPDATE Users
--chicken egg problem
UPDATE users SET memberid = 1 WHERE id = 1;

--INSERT Service Order
--id auto generated PK
--completed_flag default 0
INSERT INTO service_order
                    (memberid, service_group, service_type_mow, service_type_edge, service_type_rake, instruction, need_by_date,
                          scheduled_date, completed_date, expiration_date, 
                              create_user_name, create_date, change_user_name, change_date)
                           VALUES(1, 'lawn', 'mow', 'edge', 'rake', 'This are test instructions', 
                                   '2015-11-02', null, null, null,
                                     'gschmidt', current timestamp, 'gschmidt', current timestamp);
          
--INSERT Services
--id auto generated PK
INSERT INTO services
                    (service_group, service_group_description, service_type, service_type_description, valueid, expiration_date, create_user_name, create_date, change_user_name, change_date)
                    VALUES('lawn', 'Lawn', 'mow', 'Mow Lawn', 1, null, 'gschmidt', current timestamp, 'gschmidt', current timestamp), 
                           ('lawn', 'Lawn', 'edge', 'Edge Lawn', 2, null, 'gschmidt', current timestamp, 'gschmidt', current timestamp), 
                           ('lawn', 'Lawn', 'rake', 'Rake Leaves', 3, null, 'gschmidt', current timestamp, 'gschmidt', current timestamp); 

--INSERT Company
--id auto generated PK
INSERT INTO company 
                    (company_name, address, city, st, zip, email, phone, expiration_date, create_user_name, create_date, change_user_name, change_date)
                    VALUES('Momow Services', '123 1st Street', 'Austin', 'TX', '78728', 
                               'glenn.schmidt@g.austincc.edu', '1-800-555-2222', null,
                                    'gschmidt', current timestamp, 'gschmidt', current timestamp);

