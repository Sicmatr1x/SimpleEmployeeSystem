1.employee员工基本信息表；</br>

```sql
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

select * from employee;

insert into employee(name,age,sex) values ('Tom', 25, 'M');
insert into employee(name,age,sex) values ('Alice', 18, 'F');

delete from employee where id=3;
```

2.attend员工考勤情况表：出勤时间、出勤类型、employee</br>

```sql
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

select * from attend;
select * from benefit;
select * from salary;

delete from attend;
delete from benefit;
delete from salary;

DROP TABLE attend;
DROP TABLE benefit;
DROP TABLE job;
DROP TABLE salary;
DROP TABLE employee;

insert into attend(empid,attendDate,overtime,dayoff) values (4, "2017-04-01", 5,3);
insert into attend(empid,attendDate,overtime,dayoff) values (4, "2017-05-01", 2,0);
insert into attend(empid,attendDate,overtime,dayoff) values (4, "2017-05-01", 0,0);
insert into attend(empid,attendDate,overtime,dayoff) values (4, "2017-07-01", 1,1);

update attend
set overtime=1
where empid = 4;

update attend
set dayoff=10
where id = 7;
```

```sql
delimiter ;
--定义触发器
drop trigger if exists benefit_insert;
drop trigger if exists benefit_update;
--增加attend记录同时增加benefit记录
delimiter $
create trigger attend_insert before insert on attend
for each row
begin
    declare base int;
    --
    insert into benefit(empid,mounth,bene) values (new.empid,new.attendDate,new.overtime*200);
    --
    set base=(select baseSalary from job where empid=new.empid)-new.dayoff*200;
    insert into salary(empid,mounth,salary) values (new.empid,new.attendDate,base);
end;
$
--修改attend记录同时修改benefit记录
create trigger attend_update before update on attend
for each row
begin
    declare base int;
    --
    update benefit
    set bene=new.overtime*200
    where empid = new.empid and mounth=old.attendDate;
    --
    set base=(select baseSalary from job where empid=new.empid)-new.dayoff*200;
    update salary
    set salary=base
    where empid = new.empid and mounth=old.attendDate;
end;
$
```

3.benefit员工津贴信息表，反映员工的加班时间，加班类别、加班天数、津贴情况等：出勤时间、出勤类型、employee</br>

```sql
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

select * from benefit;

DROP TABLE benefit;

insert into benefit(empid,mounth,bene) values (1, "2017-04-01", 500);
```

4.job员工工种情况表，反映员工的工种、等级，基本工资等信息；

```sql
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

select * from job;

insert into job(empid,jobType,jobLevel,baseSalary,department) values (4, "BOSS", 5, 10000, "core");

alter table job add department VARCHAR(14);

update job
set baseSalary = 100000
where id = 1;

select employee.id as eid, name, age, sex, job.id as jid, jobType, jobLevel, baseSalary
from employee, job
where employee.id = job.empid;
```

5.salary员工月工资表。</br>

```sql
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

select * from salary

insert into salary values (1, 1, "2017-04-01", 100000);
```

月工资=基本月工资+该月津贴</br>
年终奖金计算公式＝（员工本年度的工资总和＋津贴的总和）/12</br>
年终奖算到13月津贴里(待定)</br>

```sql
select employee.id as eid, name, age, sex, job.id as jid, jobType, jobLevel, baseSalary
from employee, job
where employee.id = job.empid;
```