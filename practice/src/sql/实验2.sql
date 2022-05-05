


select sno,sname from student;
select * from student;
select distinct sno from sc;
select sno from sc where grade<60;
select sname,ssex,sage,sdept from student where sdept!='is' && sdept!='cs';
select sno,grade from sc where cno='004' order by grade desc;
select cno,count(cno) from sc group by cno;
select sname,sage,sdept from student where sdept='cs';
select sname,sage,sdept from student where sage>=18 and sage<=20;
select * from student where sname like  '刘%';
select distinct sno from sc where cno='001' and sno in(select distinct sno from sc where cno='002');
select sname,sbirth from student;
select sno,cno from sc where grade is null;
select sno from sc group by sno having sum(grade) > 200;
select cno,count(distinct sno) from sc where grade<60 group by cno;
select sno from sc where grade<60 group by sno having count(cno)>3;
select * from student where sage between 10 and 19;
select * from student order by sdept asc,sage desc;
select avg(grade) from sc where cno='001' group by cno;
select max(grade) from sc where cno='003' group by cno;
select sno,sum(grade) from sc group by sno;



