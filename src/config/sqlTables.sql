--id 工号
--name 员工姓名
--age 年龄
--sex 性别
CREATE TABLE employee(
id int primary key auto_increment,
name VARCHAR(14),
age int,
sex VARCHAR(1)
);

--empid 工号
--attendDate 出勤日期
--overtime 加班天数
--dayoff 请假天数
CREATE TABLE attend(
id int primary key auto_increment,
empid int,
attendDate DATE,
overtime int,
dayoff int,
key empid (empid),
foreign key (empid) references employee(id)
);

--empid 工号
--mounth 该月加班记录
--bene 初始为0 该月津贴 每次+200
CREATE TABLE benefit(
id int primary key auto_increment,
empid int,
mounth DATE, 
bene int,
key empid (empid),
foreign key (empid) references employee(id)
);

--empid 工号
--jobType 工种(BOSS老板:100000,PROGRAMMER程序员:10000,CLERK文员:5000)
--department 部门(develop,core)
--jobLeve 等级(1,2,3,4)
--baseSalary 基本月工资(单位：元)
CREATE TABLE job(
id int primary key auto_increment,
empid int,
jobType VARCHAR(14),
jobLevel int,
baseSalary int,
department VARCHAR(14),
key empid (empid),
foreign key (empid) references employee(id)
);

--empid 工号
--mounth 月份 2017-04-01
--salary 基本月工资
CREATE TABLE salary(
id int primary key auto_increment,
empid int,
mounth DATE,
salary int,
key empid (empid),
foreign key (empid) references employee(id)
);

--定义触发器
drop trigger if exists benefit_insert;
drop trigger if exists benefit_update;
--增加attend记录同时增加benefit,salary记录
delimiter $
create trigger attend_insert before insert on attend
for each row
begin
    declare base int;
    --计算bene该月津贴(每次加班+200)
    insert into benefit(empid,mounth,bene) values (new.empid,new.attendDate,new.overtime*200);
    --计算每月的月工资salary(请假一次-200)
    set base=(select baseSalary from job where empid=new.empid)-new.dayoff*200;
    insert into salary(empid,mounth,salary) values (new.empid,new.attendDate,base);
end;
$
--修改attend记录同时修改benefit,salary记录
create trigger attend_update before update on attend
for each row
begin
    declare base int;
    --计算bene该月津贴(每次加班+200)
    update benefit
    set bene=new.overtime*200
    where empid = new.empid and mounth=old.attendDate;
    --计算每月的月工资salary(请假一次-200)
    set base=(select baseSalary from job where empid=new.empid)-new.dayoff*200;
    update salary
    set salary=base
    where empid = new.empid and mounth=old.attendDate;
end;
$

delimiter ;

insert into employee(name,age,sex) values ('Tom', 25, 'M');
insert into employee(name,age,sex) values ('Alice', 18, 'F');


insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-01-01", 5,3);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-02-01", 2,0);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-03-01", 0,0);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-04-01", 0,1);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-05-01", 1,0);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-06-01", 4,0);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-07-01", 0,5);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-08-01", 10,0);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-09-01", 2,8);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-10-01", 0,0);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-11-01", 0,0);
insert into attend(empid,attendDate,overtime,dayoff) values (1, "2017-12-01", 0,0);

insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-01-01", 5,3);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-02-01", 2,0);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-03-01", 0,0);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-04-01", 0,1);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-05-01", 1,0);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-06-01", 4,0);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-07-01", 0,5);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-08-01", 10,0);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-09-01", 2,8);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-10-01", 0,0);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-11-01", 0,0);
insert into attend(empid,attendDate,overtime,dayoff) values (2, "2017-12-01", 0,0);