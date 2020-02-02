create TABLE salary(
    id integer primary key auto_increment,
    amount integer,
    month_year varchar(255),
    payment_date date,
    days_of_work integer,
    FOREIGN KEY (id_employee) REFERENCES Employee(id)
);