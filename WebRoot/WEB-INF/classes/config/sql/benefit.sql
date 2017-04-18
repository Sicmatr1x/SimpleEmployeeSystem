--empid 工号
--mounth 该月加班记录
--overtime 月加班天数(单位：天)
CREATE TABLE benefit(
id int,
empid int,
mounth DATE,
overtime int,
PRIMARY KEY(id),
key empid (empid),
foreign key (empid) references employee(id)
);
