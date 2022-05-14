-- 一个学生信息表
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
-- 一个商品表
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
-- 一个客户信息表
create table customer(
    customer_id int,
    customer_name varchar(20),
     address varchar(50),
    email varchar(50),
    sex varchar(5),
    card_id varchar(18)
);
-- 一个购买清单
create table purchase(
    order_id int,
    customer_id int,
    goods_id int,
    nums int
);
-- 一张图书表
create table books(
    name varchar(20),
    author varchar(20),
    price decimal(7,2),
    classify varchar(20)
);
-- 一张老师表
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

insert into books values ('Java核心技术','Cay S. Horstman',56.43,'计算机技术');
insert into  goods (goods_name,unitprice,repertory)  values ('学生书包',18.91,101);
insert into goods values ('学生书包',18.91,101,null);

create database test;

create table exam_result(
    id int,
    name varchar(20),
    chinese decimal(3,1),
    math decimal(3,1),
    english decimal(3,1)
);
-- 插入数据,into可省
insert into exam_result values
(1,'唐三藏',68.2,78.3,48.4),
(2,'孙悟空',66.2,67.3,69.4),
(3,'猪八戒',62.6,69.3,59.4),
(4,'沙和尚',28.2,48.3,88.4),
(5,'曹孟德',70.2,90.3,60.4),
(6,'刘玄德',56.2,66.3,66.4),
(7,'孙仲谋',96.2,82.3,56.4),
(8,'关云长',null,null,null);

-- 1.查询全列数据
select*from [表名];
-- 查询当前数据
select*from exam_result;

-- 2.查询指定列数据
select [列名],[列名]...from [表名];
-- 显示顺序和查找顺序相对应
select id,name from exam_result;

-- 3.查询字段为表达式
select [列名]+[列名]+.... from [表名]
select name,chinese+english+math from exam_result;

-- 4.指定别名,as可省
select [列名]+[列名]+....as[别名] from [表名]
select name,chinese+english+math as total from exam_result;

-- 5.查找信息并去重,列名必须放到distinct之后
select distinct [列名],... from [表名];
select distinct chinese from exam_result;

-- 6.查找信息并排序order by asc(升序)/desc(降序)
select*from [表名] order by [列名] asc;
select*from exam_result order by scale asc;
select*from exam_result order by chinese desc;

-- 7.查找信息并按照总成绩排序,null加上任何值都为null
select name,chinese+math+english as total  from exam_result order by total desc;

-- 8.按照多列来排序,列名越靠前优先级越高,null值默认是最小的
select*from [表名] order by [列名] desc,[列名] desc,..;
select * from exam_result order by chinese desc,math desc,english desc;

-- 查找成绩为null的人
-- 这样的写法是不行的,因为 null=null的结果为false
select * from exam_result where chinese = null;
-- 以下写法才可以查到null
select * from exam_result where chinese <=> null;
select * from exam_result where chinese is null;

-- 指定成绩查询
-- 1.语文成绩大于70
select * from exam_result where chinese>70;
-- 2.语文成绩介于70到90之间
select * from exam_result where chinese > 70 and chinese < 90;
select * from exam_result where chinese between 70 and 90;
-- 3.查找指定的成绩
select * from exam_result where chinese in (62.6,70.2,96.2);
-- 4.查询三科成绩之和大于180,where不可以使用别名充当条件
select name,chinese+math+english as total from exam_result where total>180;
-- 下面的写法才是正确的
select name,chinese+math+english as total from exam_result where chinese+math+english>180;

-- 根据特征来查询
select * from exam_result where like '孙%';
select * from exam_result where chinese like '6%';

-- 分页查询
select * from exam_result limit 3;
select * from exam_result order by id limit 3 offset 2;

-- 修改
update exam_result set math = 80 where name='孙悟空';

-- 删除
delete from exam_result;
delete from exam_result where math is null;

-- 约束,对插入的数据进行校验

-- 非空,not null
create table stu(id int not null ,name varchar(20));
-- 唯一,unique
create table stu1(id int unique ,name varchar(20));
-- 默认值,default
create table stu2(id int ,name varchar(20) default 未命名);
-- 主键,primary key,相当于 unique+not null,设置自增主键auto_increment;
create table stu3(id int primary key,name varchar(20));
-- 外键,foreign key;

-- 自定义条件,check,mysql5并不生效










