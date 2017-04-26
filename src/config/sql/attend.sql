--empid 工号
--attendDate 出勤日期
--overtime 加班天数
--dayoff 请假天数
CREATE TABLE attend(
id int,
empid int,
attendDate DATE,
overtime int,
dayoff int,
PRIMARY KEY(id),
key empid (empid),
foreign key (empid) references employee(id)
);
