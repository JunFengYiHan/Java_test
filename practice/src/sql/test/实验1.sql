
create database student;

use student;

create table student(
    sno char(8),-- 学号
    sname varchar(8), -- 姓名
    ssex char(2), -- 性别
    sage int,-- 年龄
    sdept varchar(20) -- 系别
);
create table course(
    cno char(3),-- 课程号
    cname varchar(20), -- 课程名称
    cpno char(3),-- 系别
    credit numeric(3,1) -- 学分
);

create table sc(
    sno char(8),-- 学号
    cno char(3),-- 课程号
    grade numeric(4,1)-- 成绩
);
-- truncate table tabName[表名],清空表数据
--7
insert  student values ('08001','张力','男',18,'cs'),('08002','李丽','女',19,'is'),
('08003','赵海','男',20,'ma'),('08004','张那','女',17,'cs'),('08005','刘晨','男',18,'is'),
('08006','刘丹丹','女',17,'ma'),('08007','刘立','男',21,'cs'),('08008','王江','男',19,'cs'),
('08009','高晓','男',20,'is'),('08010','张丽','女',19,'cs');

insert course values ('001','数据库','005',4),('002','高等数学',null,2),('003','信息系统','001',4),
('004','其他练习.学校练习.操作系统','006',3),('005','数据结构','007',4),('006','数据处理',null,2),('007','C语言','006',4);


insert sc values ('08001','002',100),('08001','003',95),('08001','004',90),('08001','006',100),
('08002','002',98),('08002','003',null),('08003','001',99),('08003','002',80),('08003','003',98),
('08004','001',90),('08005','002',37),('08005','007',97),('08006','003',null),('08008','001',50),
('08008','003',80),('08009','001',59),('08009','004',90),('08010','005',100),(null,NULL,0);
--8
-- column可省
alter table student change column sno sno char(8) not null unique;
alter table student add sbirth timestamp ,add address text;
alter table student drop address;
alter table course change cno cno char(3) not null unique ;
--9
create table temp(id int);
drop table temp;
--10
create index sname on student(sname desc);
--11
create index grade on sc(grade asc);
--12
drop index sname on student;
drop index grade on sc;














