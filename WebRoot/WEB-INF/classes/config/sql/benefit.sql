--empid 工号
--mounth 该月加班记录
--bene 初始为0 该月津贴 每次+200
CREATE TABLE benefit(
id int,
empid int,
mounth DATE, 
bene int,
PRIMARY KEY(id),
key empid (empid),
foreign key (empid) references employee(id)
);