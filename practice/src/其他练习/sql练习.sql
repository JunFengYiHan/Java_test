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