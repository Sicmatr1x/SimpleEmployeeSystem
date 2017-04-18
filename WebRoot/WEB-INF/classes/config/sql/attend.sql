--empid 工号
--attendDate 出勤日期
--attendType 出勤类型(0正常上班，1加班,2请假)
CREATE TABLE attend(
id int,
empid int,
attendDate DATE,
attendType int,
PRIMARY KEY(id),
key empid (empid),
foreign key (empid) references employee(id)
);