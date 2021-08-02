--一个学生信息表
create table student(
    id int,
    name varchar(20),
    age int,
    score decimal(3,1)
);
create table student2(
    id int,
    name varchar(20),
    password varchar(20),
    age TINYINT,
    sex varchar(5),
    birthday timestamp,
    score decimal(3,1),
    resume text
);
--一个商品表
create table goods(
    goods_id INT,
    goods_name varchar(20),
    unitprice decimal(10,1),
    category varchar(10),
    provider varchar(20)
);
--一个客户信息表
create table customer(
    customer_id int,
    customer_name varchar(20),
     address varchar(50),
    email varchar(50),
    sex varchar(5),
    card_id varchar(18)
);
--一个购买清单
create table purchase(
    order_id int,
    customer_id int,
    goods_id int,
    nums int
);

create database 08_02练习;

create table exam_result(
    id int,
    name varchar(20),
    chinese decimal(3,1),
    math decimal(3,1),
    english decimal(3,1)
);
--插入数据,into可省
insert into exam_result values
(1,'唐三藏',78.2,78.3,78.4),
(2,'孙悟空',67.2,67.3,67.4),
(3,'猪八戒',69.6,69.3,69.4),
(4,'沙和尚',88.2,88.3,88.4),
(5,'曹孟德',90.2,90.3,90.4),
(6,'刘玄德',66.2,66.3,66.4),
(7,'孙仲谋',86.2,86.3,86.4);

-- 查看所有列
select*from exam_result;
-- 查看指定列
select id,name from exam_result;
-- 指定别名,as可省
select name,chinese+english+math as total from exam_result;
--去重
select distinct chinese from exam_result;
--排序,升序
select*from exam_result order by chinese asc;
--排序,降序
select*from exam_result order by chinese desc;
--按照综合成绩来排名
select name,chinese+math+english total  from exam_result order by total desc;
--按照多科成绩排序
select * from exam_result order by chinese desc,math desc,english desc;











