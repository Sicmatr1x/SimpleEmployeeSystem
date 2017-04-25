employee
```sql
--id 工号
--name 员工姓名
--age 年龄
--sex 性别
```

attend
```sql
--empid 工号
--attendDate 出勤日期
--attendType 出勤类型(0正常上班，1加班,2请假)
```

benefit
```sql
--empid 工号
--mounth 该月加班记录
--overtime 月加班天数(单位：天)
```

job
```sql
--empid 工号
--jobType 工种(BOSS老板:100000,PROGRAMMER程序员:10000,CLERK文员:5000)
--department 部门
--jobLeve 等级(1:*1.0,2:*1.4,3*1.8,4*2.0)
--baseSalary 基本月工资(单位：元)
```

salary
```sql
--empid 工号
--mounth 月份 2017-04-01
--salary 月工资=基本月工资+该月津贴
```