drop table if exists classes;
drop table if exists student;
drop table if exists course;
drop table if exists score;

create table classes (id int primary key auto_increment, name varchar(20), `desc` varchar(100));

create table student (id int primary key auto_increment, sn varchar(20),  name varchar(20), qq_mail varchar(20) , classes_id int);

create table course(id int primary key auto_increment, name varchar(20));

create table score(score decimal(3, 1), student_id int, course_id int);

insert into classes(name, `desc`) values 
('class1', 'desc1'),
('class2','desc2'),
('class3','desc3');

insert into student(sn, name, qq_mail, classes_id) values
('09982','likui','xuanfeng@qq.com',1),
('00835','puti',null,1),
('00391','baisuzhen',null,1),
('00031','xuxian','xuxian@qq.com',1),
('00054','buxiangbiye',null,1),
('51234','haohaoshuohua','say@qq.com',2),
('83223','tellme',null,2),
('09527','laowai','foreigner@qq.com',2);

insert into course(name) values
('Java'),('wenhua'),('yuanli'),('chinese'),('math'),('english');

insert into score(score, student_id, course_id) values
-- likui
(70.5, 1, 1),(98.5, 1, 3),(33, 1, 5),(98, 1, 6),
-- puti
(60, 2, 1),(59.5, 2, 5),
-- baisuzhen
(33, 3, 1),(68, 3, 3),(99, 3, 5),
-- xuxian
(67, 4, 1),(23, 4, 3),(56, 4, 5),(72, 4, 6),
-- buxiangbiye
(81, 5, 1),(37, 5, 5),
-- haohaoshuohua
(56, 6, 2),(43, 6, 4),(79, 6, 6),
-- tellme
(80, 7, 2),(92, 7, 6);