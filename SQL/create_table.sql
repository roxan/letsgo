CREATE TABLE PERSON(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 101, INCREMENT BY 1),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(12) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(20) NOT NULL,
	avatar BLOB
);

CREATE TABLE PERSON_ADDRESS(
    id INTEGER NOT NULL PRIMARY KEY
      GENERATED ALWAYS AS IDENTITY
        (START WITH 101, INCREMENT BY 1),
    person_id INT NOT NULL,
    street VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state VARCHAR(30) NOT NULL,
	country VARCHAR(30) NOT NULL,
	zip VARCHAR(20) NOT NULL     
 );
 
CREATE TABLE RIDE(
    id INTEGER NOT NULL PRIMARY KEY
      GENERATED ALWAYS AS IDENTITY
        (START WITH 101, INCREMENT BY 1),
    person_id INT NOT NULL,
    source VARCHAR(50) NOT NULL,
	destination VARCHAR(50) NOT NULL,
	depart_date DATE NOT NULL,
	depart_time TIME NOT NULL,
	return_date DATE,
	return_time TIME,
	description VARCHAR(250),
	capacity INT,
	vehicle_description VARCHAR(250) NOT NULL,
	expected_expense DECIMAL(10,2),
	ride_type VARCHAR(30) 
 );

CREATE TABLE Location(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 101, INCREMENT BY 1),
    cityName VARCHAR(50) NOT NULL,
    stateName VARCHAR(50) NOT NULL,
	zip char(5) NOT NULL
);