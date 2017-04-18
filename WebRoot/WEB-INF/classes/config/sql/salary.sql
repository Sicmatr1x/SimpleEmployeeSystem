CREATE TABLE salary(
id int,
empid int,
mounth DATE,
salary int,
PRIMARY KEY(id),
key empid (empid),
foreign key (empid) references employee(id)
);