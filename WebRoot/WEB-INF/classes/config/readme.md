# 数据库分析与设计实习
## 一、《数据库系统》设计实习目标：
1．掌握数据库应用系统设计的特点、方法和基本步骤，在Windows环境下开发一个基于数据库的应用系统。<br />
2．掌握设计实现一个完整的数据库应用系统的流程和方法，包括功能分析、数据库设计、应用程序设计。<br />
3．熟悉对数据库的操作，包括数据库连接、SQL、完整性约束、索引，以及视图、触发器、存储过程等数据库对象的综合运用。<br />
4．加深理论基础：关系数据库、数据库设计、事务。<br />

## 二、	开发说明：
1. 语言：开发语言有JAVA、VB、VC、PB、C#等，选择任意个人熟悉的语言。<br />
2. 数据库：使用Oracle、My SQL等数据库。<br />
3. 分组：可1～3人一组完成一个题目。多人完成请注明分工，按照贡献大小排序。<br />

## 三、	提交说明：
1. 完成时间：7周。第6周开始（3月27日），第15周结束（5月12日），共9周时间。<br />
2. 在15周前（5月12日）交齐：每组交一份报告和源代码，由学委收齐全班同学的实习报告、源程序，并填写班内互评统计表统一上交。<br />

## 四、《数据库系统》设计实习选题及要求(仅供参考，建议自拟题目)：

## 选题一：工资管理系统
### 1、系统功能的基本要求：<br />
员工每个工种基本工资的设定；<br />
加班津贴管理，根据加班时间和类型给予不同的加班津贴；<br />
按照不同工种的基本工资情况、员工的考勤情况产生员工的每月的月工资；<br />
员工年终奖金的生成，员工的年终奖金计算公式＝（员工本年度的工资总和＋津贴的总和）/12；<br />
能够查询单个员工的工资情况、每个部门的工资情况、按月的工资统计；<br />

### 2、数据库要求：在数据库中至少应该包含下列数据表：<br />
1.employee员工基本信息表；<br />
2.attend员工考勤情况表：出勤时间、出勤类型、employee<br />
3.benefit员工津贴信息表，反映员工的加班时间，加班类别、加班天数、津贴情况等：出勤时间、出勤类型、employee<br />
4.job员工工种情况表，反映员工的工种、等级，基本工资等信息；employee<br />
5.salary员工月工资表。<br />
```sql
mysql -uroot
use employee;
SHOW TABLES;
```

1.employee员工基本信息表；<br />

```sql
--id 工号
--name 员工姓名
--age 年龄
--sex 性别
CREATE TABLE employee(
id int,
name VARCHAR(14),
age int,
sex VARCHAR(1),
PRIMARY KEY(id)
);

select * from employee;

insert into employee values (1, 'Tom', 25, 'M');
insert into employee values (2, 'Alice', 18, 'F');

delete from employee where id=3;

```

2.attend员工考勤情况表：出勤时间、出勤类型、employee<br />

```sql
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

select * from attend;

insert into attend values (1, 1, "2017-04-15", 0);

update attend
set attendDate = "2017-04-15"
where id = 1;

select employee.id as eid, name, age, sex, attend.id as aid, attendDate, attendType
from employee, attend
where employee.id = attend.empid;
```

3.benefit员工津贴信息表，反映员工的加班时间，加班类别、加班天数、津贴情况等：出勤时间、出勤类型、employee<br />

```sql
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

select * from benefit;

insert into benefit values (1, 1, "2017-04-01", 1);

select employee.id as eid, name, age, sex, benefit.id as bid, mounth, overtime
from employee, benefit
where employee.id = benefit.empid;
```

4.job员工工种情况表，反映员工的工种、等级，基本工资等信息；

```sql
--empid 工号
--jobType 工种(BOSS老板:100000,PROGRAMMER程序员:10000,CLERK文员:5000)
--department 部门
--jobLeve 等级(1:*1.0,2:*1.4,3*1.8,4*2.0)
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

insert into job values (1, 1, "BOSS", 5, 10000);

alter table job add department VARCHAR(14);

update job
set baseSalary = 100000
where id = 1;

select employee.id as eid, name, age, sex, job.id as jid, jobType, jobLevel, baseSalary
from employee, job
where employee.id = job.empid;
```

5.salary员工月工资表。<br />

```sql
--empid 工号
--mounth 月份 2017-04-01
--salary 月工资=基本月工资+该月津贴
CREATE TABLE salary(
id int,
empid int,
mounth DATE,
salary int,
PRIMARY KEY(id),
key empid (empid),
foreign key (empid) references employee(id)
);

select * from salary

insert into salary values (1, 1, "2017-04-01", 100000);
```

月工资=基本月工资+该月津贴<br />
年终奖金计算公式＝（员工本年度的工资总和＋津贴的总和）/12<br />
年终奖算到13月津贴里(待定)<br />

```sql
select employee.id as eid, name, age, sex, job.id as jid, jobType, jobLevel, baseSalary
from employee, job
where employee.id = job.empid;
```


### 3、本课题设计的基本要求：<br />
（1）	必须提交系统分析报告，包括系统的功能分析、系统的功能模块设计、数据库的数据字典，数据库的概念结构（E－R图），数据库中的表、视图（如果使用）、存储过程（如果使用）的结构和定义（可以用SQL脚本提供）；<br />
（2）	程序设计的报告：包括程序的运行环境、开发环境、程序的详细设计（包括模块之间的关系，模块的功能、主要功能实现的程序段）<br />
（3）	 系统的源程序，包括数据库脚本程序。<br />
