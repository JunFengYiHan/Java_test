



create table 仓库表(
    仓库号   int primary key,
    商品数量  int   ,
    仓库所在地 varchar(100) ,
    存储容量  int
);

create table 商品表(
    商品号  int  primary key aotu_increment,
    仓库号  int,
    商品名称 varchar(50),
    厂家   varchar(50),
    数量   int ,
    生产日期 datetime
);

create table 管理员表(
    仓库管理员ID int primary key,
    姓名      varchar(10),
    -- 性别      varchar(2),
    -- 年龄      int,
    -- 电话      varchar(12),
    密码      varchar(20)
);

create table 用户表(
    用户ID int  primary key,
    姓名   varchar(20),
    性别   varchar(2),
    电话   varchar(12)
);

create table 借记表(
    借记单号  int primary key,
    用户ID  int,
    商品名称  varchar(50) ,
    厂家    varchar(50),
    数量    int ,
    借出日期  datetime,
    归还日期  datetime,
    仓库号   int,
    借出人姓名 varchar(50) ,
    商品号   int,
    constraint 仓库号1 foreign key (仓库号) references 仓库表 (仓库号),
    constraint 商品号1 foreign key (商品号) references 商品表 (商品号),
    constraint 用户ID1 foreign key (用户ID) references 用户表 (用户ID)
);

create table 入库表(
    入库单号 int primary key,
    用户ID int ,
    商品名称 varchar(20),
    厂家   varchar(50),
    数量   int ,
    日期   datetime,
    送货员工 varchar(20),
    仓库号  int,
    constraint 仓库号2 foreign key (仓库号) references 仓库表 (仓库号),
    constraint 用户ID2 foreign key (用户ID) references 用户表 (用户ID)
);

create table 出库表(
    出库单号 int  primary key,
    用户ID int,
    商品名称 varchar(50),
    厂家   varchar(50),
    数量   int,
    日期   datetime,
    提货人  varchar(20),
    仓库号  int,
    商品号  int,
    constraint 仓库号3 foreign key (仓库号) references 仓库表 (仓库号),
    constraint 商品号2 foreign key (商品号) references 商品表 (商品号),
    constraint 用户ID3 foreign key (用户ID) references 用户表 (用户ID)
);


insert into 管理员表 values(1,'忆寒',123456);

insert into 用户表 values(1,'张三','男','155615'),(2,'李四','男','121653');

insert into 商品表 values(1,1,'ad钙','ad钙',500,20200402);
insert into 商品表 values(2,2,'卫龙','卫龙',500,20200506152042);

insert into 入库表 values(1,1,'七喜','七喜',564,20200609,'忆寒',1);

insert into







