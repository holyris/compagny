CREATE TABLE employee(
    id integer primary key auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    street_number integer,
    street_name varchar(255),
    postcode integer,
    city varchar(255),
    country varchar(255),
    salary double
);