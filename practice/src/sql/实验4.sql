





insert student values('95030','李莉','女',18,'is');
insert sc values('95030','1',null);
update student set sage=20 where sdept='cs';
update sc set grade=0 where sno in(select sno from student where sdept='ma');
update sc set grade = grade+5 where sno in (select sno from student where ssex='nv')
and grade < (select* from (select avg(grade) from sc) as avgGrade);
update sc set grade = grade*1.04 where cno='002' and grade>75;
update sc set grade = grade*1.05 where cno='002' and grade<75;
delete from student where sno='95030';
delete from sc where grade is null;
delete from sc where sno in(select sno from student where sname='张那');
delete from sc where sno in(select sno from student where sdept='ma');
delete from sc where grade<60;
create table stu (sno char(8),sname varchar(8),ssex char(2));
insert stu select distinct sno,sname,ssex from student where sno
in(select sno from sc where grade>=80);
create table sno_cno (sno char(8),cno char(3));
insert sno_cno select distinct sno,cno from sc;
update student set sage = sage+1;
create table stu1 (sname varchar(8),sdept varchar(20));
insert stu1 select sno,sdept from student where sno in(select distinct sno
from sc where grade<60 group by sno having count(grade)>3);