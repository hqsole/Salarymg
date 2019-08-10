create table Staff(--创建员工表
Job_number VARCHAR(50) NOT NULL primary key,
Name VARCHAR(50) NOT NULL,
Gender CHAR(2)CHECK(Gender IN('男','女')),
Age int NOT NULL,
Hometown VARCHAR(50) NOT NULL,
ID_number VARCHAR(50) UNIQUE NOT NULL,
Marital_status VARCHAR(50),
Educational VARCHAR(50),
Department VARCHAR(50) NOT NULL,
Trades VARCHAR(50),
gongling VARCHAR(50) NOT NULL,
Job_classification VARCHAR(50),
Post_wages decimal not null
)
create table Depart(--创建部门表
Job_number VARCHAR(50) NOT NULL,
Department VARCHAR(50) primary key NOT NULL,
header VARCHAR(50) NOT NULL,
Sector_workforce VARCHAR(50)
)
CREATE TABLE Wage(--创建工资表
Job_number varchar(50) not null primary key foreign key references Staff(Job_number),
Job_subsidies decimal,
Attendance_Days decimal not null,
Overtime_hours decimal, 
Overtime_Days decimal, 
Overtime_Category decimal,
Overtime_pay varchar(50),
Sick_leave_deductions decimal,
Leave_chargeback decimal, 
Other_deductions decimal, 
Should_wages decimal not null, 
Real_wages decimal not null
)
go
CREATE VIEW Staff_Wage--创建视图：员工-工资
AS 
SELECT Staff.Name 姓名, Wage.Job_number 工号,Staff.Post_wages 岗位工资,Wage.Job_subsidies 岗位补贴,
Wage.Attendance_Days 出勤天数,Wage.Overtime_hours 加班工时,Wage.Overtime_Days 加班天数,
Wage.Overtime_Category 加班类别,Wage.Overtime_pay 加班工资,Wage.Sick_leave_deductions 病假扣款,
Wage.Leave_chargeback 事假扣款,Wage.Other_deductions 其他扣款,Wage.Should_wages 应发工资,
Wage.Real_wages 实发工资
FROM  Staff,Wage
WHERE  Staff.Job_number=Wage.Job_number;
go
go
CREATE VIEW DepartStaff_renshi--创建视图：部门-人员（人事部）--这里为举例,若有其他部门,可以继续建立相关视图.
AS
SELECT Staff.Job_number 工号,Staff.Name 姓名,Staff.Gender 性别,Staff.Age 年龄,Staff.Hometown 籍贯,
Staff.ID_number 身份证号,Staff.Marital_status 婚姻状况,Staff.Educational 学历,Staff.Department 部门名称,
Staff.Trades 工种,Staff.gongling 工龄,Staff.Job_classification 职务等级,Staff.Post_wages 岗位工资
FROM Depart,Staff
WHERE Depart.Department=Staff.Department and Staff.Department='人事部';
go
CREATE INDEX Job_number_name_ind--创建索引
ON staff(Job_number,Name)

--定义存储过程以,岗位补贴(＠staffgongzi)、出勤天数(＠staffchuqin)、加班工资(＠staffjiaban)、
--应发工资(＠staffying)、实发工资(＠staffshi)为输入参数返回指定员工工资信息。
go
CREATE PROCEDURE staffCost
@staffgongzi decimal,
@staffchuqin decimal,
@staffjiaban decimal,
@staffying decimal,
@staffshi decimal
AS
SELECT *
FROM Wage
WHERE Job_subsidies=@staffgongzi AND Attendance_Days=@staffchuqin AND Overtime_pay=@staffjiaban AND 
      Should_wages=@staffying AND Real_wages=@staffshi;
	  go
--创建触发器:员工内部调动,当系统对员工表进行UPDATE操作后，将会自动触发它。
--该触发器将相应记录的部门人数、部门名称、工资更新。
CREATE TRIGGER tri1 
ON Staff for insert
as
update Depart set Sector_workforce=Sector_workforce+1
   where Depart.Job_number in(select Job_number from inserted)
go
--建立用户u1，登陆名sss，密码123456.
CREATE LOGIN sss WITH PASSWORD='123456'
USE  gongzigl 
CREATE USER u1 FOR LOGIN sss;
--给u1授权
grant all privileges
on staff
to u1
with grant option;
CREATE LOGIN ss WITH PASSWORD='123456'
USE  gongzigl 
CREATE USER u2 FOR LOGIN ss
grant update,insert
on staff
to u2
with grant option;
CREATE LOGIN s WITH PASSWORD='123456'
USE  gongzigl 
CREATE USER u3 FOR LOGIN s
grant select
on staff
to u3
with grant option;