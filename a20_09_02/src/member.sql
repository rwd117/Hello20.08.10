drop table member;
create table member (	
	code varchar2(10) not null,
	name varchar2(30) not null,
	id varchar2(30),
	pwd varchar2(15),
	age number(5)
)


insert into member(code,name,id,pwd,age)
 values('1001','강지아','jeea','1111',20);

insert into member(code,name,id,pwd,age)
 values('1002','강지민','jeem','2222',20);
	
insert into member(code,name,id,pwd,age)
 values('1003','강지시','jees','3333',18);

insert into member(code,name,id,pwd,age)
 values('1003','강지사','jeea','4444',18);
 
--insert into member(id,pwd,age)
-- values('jees','3333',20); //에러, 설정상 null로 설정해놨기 때문에 필수로 입력을 해야함.
 
 select* from member;
 
select code, name from member;
select code, name, age from member where code='1001';
select age from member;
select distinct age from member;
select * from member where name='강지사';
select * from member where name like '강%';
select * from member where name like '강__' and code='1002';
select * from member order by name asc;
select * from member order by name desc;
select name, '너의 나이는',age from member;
select name,age+10 from member;
select count(*) from member;

--count(),sum(),avg(),max(),min()

select * from member where age in(20,30);
select * from member where age=20 or age=30;
select * from member where age not in(20,30);
select * from member where age between 20 and 30;
select * from member where pwd is null;
select * from member where pwd is not null;
select avg(age) from member;
select age from member group by age;
select avg(age) from member group by age;
select age,count(age) from member group by age;

update member set pwd='1234' where name='강지아';
select* from member;

update member set code='1005' where name like '%사';
select* from member;

update member set age=age+1 where name='강지시' and pwd='3333';
select* from member;

delete from member where name='강지사';
select * from member;

delete from member where name like '%시%';
select * from member;

delete from member;
select * from member;
commit;

--dml insert,update,select,delete
--ddl create,alter,drop

--alter table () add 
--alter table () modify 데이터 바꾸기
--alter table () drop

alter table member add (email varchar2(20));
select * from member;

alter table member modify(email varchar2(40));
select * from member;

alter table member drop column email;
select * from member;

drop table member;

