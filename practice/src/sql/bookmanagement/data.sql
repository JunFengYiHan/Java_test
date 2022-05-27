




create database if not exists bookmanagement;
use bookmanagement;

drop table if exists book;
create table book(
    bookId int primary key auto_increment,
    name varchar(20),
    author varchar(20),
    -- 以分为单位
    price int,
    type varchar(20),
    -- 0表示未借出,1表示借出
    isBorrowed int
);
insert into book values(null,"西游记","吴承恩",5300,"古典小说",0);
insert into book values(null,"三国演义","罗贯中",5300,"古典小说",0);
insert into book values(null,"水浒传","施耐庵",5300,"古典小说",0);
insert into book values(null,"红楼梦","曹雪芹",5300,"古典小说",0);

drop table if exists User;
create table user(
    userId int primary key auto_increment,
    userName varchar(20) unique,
    password varchar(20),
    -- 1表示是管理员,0表示不是
    isAdmin int
);



