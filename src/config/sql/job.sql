--empid 工号
--jobType 工种(BOSS老板:100000,PROGRAMMER程序员:10000,CLERK文员:5000)
--department 部门
--jobLeve 等级(1,2,3,4)
--baseSalary 基本月工资(单位：元)
CREATE TABLE job(
id int,
empid int,
jobType VARCHAR(14),
jobLevel int,
baseSalary int,
department VARCHAR(14),
PRIMARY KEY(id),
key empid (empid),
foreign key (empid) references employee(id)
);