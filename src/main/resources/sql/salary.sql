create TABLE salary(
    id integer primary key auto_increment,
    amount integer,
    month_year varchar(255),
    payment_date date,
    daysOfWork integer,
    FOREIGN KEY (idEmployee) REFERENCES Employee(id)
);