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
--attendDate 出勤日期"2017-04-15"
--attendType 出勤类型(0正常上班，1加班,2请假)
```
```sql
--empid 工号
--attendDate 出勤月份"2017-04-01"
overtime 加班天数
dayoff 请假天数
```

benefit
```sql
--empid 工号
--mounth 该月加班记录"2017-04-01"
--overtime 初始为0 该月津贴 每次+200
```
```sql
--empid 工号
--mounth 该月加班记录"2017-04-01"
bene 初始为0 该月津贴 每次+200
```

job
```sql
--empid 工号
--jobType 工种(BOSS老板:100000,PROGRAMMER程序员:10000,CLERK文员:5000)
--department 部门
--jobLeve 等级(1,2:,3,4)
--baseSalary 基本月工资(单位：元)
```

salary
```sql
--empid 工号
--mounth 月份 2017-04-01
--salary 月工资=基本月工资+该月津贴
```