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
create table goods(
    goods_name varchar(20),
    unitprice decimal(10,1),
    repertory decimal(10,1),
    description varchar(20)
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
--一张图书表
create table books(
    name varchar(20),
    author varchar(20),
    price decimal(7,2),
    classify varchar(20)
);
--一张老师表
create table teacher(
    name varchar(20),
    age int,
    height decimal(4,1),
    weight decimal(4,1),
    sex varchar(5),
    educationBackground varchar(10),
    birthday date,
    id_number varchar(18)
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
(1,'唐三藏',68.2,78.3,48.4),
(2,'孙悟空',66.2,67.3,69.4),
(3,'猪八戒',62.6,69.3,59.4),
(4,'沙和尚',28.2,48.3,88.4),
(5,'曹孟德',70.2,90.3,60.4),
(6,'刘玄德',56.2,66.3,66.4),
(7,'孙仲谋',96.2,82.3,56.4),
(8,'关云长',null,null,null);

--1.查询全列数据
select*from [表名];
--查询当前数据
select*from exam_result;

--2.查询指定列数据
select [列名],[列名]...from [表名];
--显示顺序和查找顺序相对应
select id,name from exam_result;

--3.查询字段为表达式
select [列名]+[列名]+.... from [表名]
select name,chinese+english+math from exam_result;

--4.指定别名,as可省
select [列名]+[列名]+....as[别名] from [表名]
select name,chinese+english+math as total from exam_result;

--5.查找信息并去重,列名必须放到distinct之后
select distinct [列名],... from [表名];
select distinct chinese from exam_result;

--6.查找信息并排序order by asc(升序)/desc(降序)
select*from [表名] order by [列名] asc;
select*from exam_result order by scale asc;
select*from exam_result order by chinese desc;

--7.查找信息并按照总成绩排序,null加上任何值都为null
select name,chinese+math+english as total  from exam_result order by total desc;

--8.按照多列来排序,列名越靠前优先级越高,null值默认是最小的
select*from [表名] order by [列名] desc,[列名] desc,..;
select * from exam_result order by chinese desc,math desc,english desc;

-- 查找成绩为null的人
--这样的写法是不行的,因为 null=null的结果为false
select * from exam_result where chinese = null;
--以下写法才可以查到null
select * from exam_result where chinese <=> null;
select * from exam_result where chinese is null;

-- 指定成绩查询
--1.语文成绩大于70
select * from exam_result where chinese>70;
--2.语文成绩介于70到90之间
select * from exam_result where chinese > 70 and chinese < 90;
select * from exam_result where chinese between 70 and 90;
--3.查找指定的成绩
select * from exam_result where chinese in (62.6,70.2,96.2);
--4.查询三科成绩之和大于180,where不可以使用别名充当条件
select name,chinese+math+english as total from exam_result where total>180;
--下面的写法才是正确的
select name,chinese+math+english as total from exam_result where chinese+math+english>180;

-- 根据特征来查询
select * from exam_result where like '孙%';
select * from exam_result where chinese like '6%';


