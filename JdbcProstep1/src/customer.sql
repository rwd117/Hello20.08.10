create table customer(
	code number(10) primary key,
	name varchar(30) not null,
	email varchar(30) not null,
	tel varchar(35)
)

insert into customer values(1,'������','jeea@shop.com','02-137-1484');
insert into customer values(2,'�����','rose@shop.com','02-523-8715');
insert into customer values(3,'�����','lily@shop.com','02-789-2359');

select * from customer;