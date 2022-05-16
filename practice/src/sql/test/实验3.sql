




select student.*,cname,credit from student,course,sc where student.sno = sc.sno and sc.cno = course.cno;
select first.cno as 课程号,first.cname as 课程名,second.cpno as 间接先修课 from course as first , course as second where first.cpno = second.cno;
select student.*,sc.* from student right join sc on student.sno = sc.sno;
select distinct sname,sdept from student,sc where student.sno = sc.sno and sc.grade<60;
select distinct sname  from student where sno in(select sno from sc group by sno having min(grade)>=90);
select sname,sno from student where sno in (select sc1.sno from sc sc1,sc sc2 where sc1.sno = sc2.sno and sc1.cno='002' and sc2.cno='003');
select * from student where sage = (select sage from student where sname = '刘晨') and sname != '刘晨';
select sname,sage from student,sc where student.sno = sc.sno and sc.cno = (select cno from course where cname = '数据库');
select * from student where sage< (select max(sage) from student where sdept = 'is') and sdept != 'is';
select * from student where sage< (select min(sage) from student where sdept = 'is') and sdept != 'is';
select sname from student where sno in (select sno from sc group by sno having count(*) = (select count(*) from course));
select * from student where ssex = '男' and sdept = 'cs';
select * from student where sno in(select sno from sc where cno='001' and sno not in(select sno from sc where cno='002'));
select cno from course where cno not in (select cno from sc where sno = (select sno from student where sname = '李丽'));
select avg(sage) from student where sno in (select sno from sc where cno = '003');
select cno,avg(grade) as 平均成绩 from sc group by cno order by cno asc;
select cno,count(*) 选修人数 from sc group by cno having count(*)>3 order by 选修人数 desc ,cno;
select sname from student where sno>(select sno from student where sname='刘晨') and sage<(select sage from student where sname='刘晨');
select sname,sage from student where ssex='男' and sage > (select avg(sage) from student where ssex='女');
select sname,sage from student where ssex='男' and sage > (select max(sage) from student where ssex='女');
select distinct sno from sc x where not exists(select * from sc y where y.sno = '08002' and not exists( select * from sc z where z.cno = y.cno and z.sno = x.sno ));
select * from course where cno in (select cno from sc where sno='08001' and cno in(select cno from sc where sno='08002'));




