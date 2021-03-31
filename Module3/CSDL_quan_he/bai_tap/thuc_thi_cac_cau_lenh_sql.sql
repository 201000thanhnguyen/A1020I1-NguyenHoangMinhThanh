create database classsicmodels;

use classsicmodels;

create table customers(
	customername varchar(50),
    phone varchar(50),
    city varchar(50),
    country varchar(50)
);

alter table customers add idcustomers int primary key auto_increment;

insert into customers (`customername`, `phone`, `city`, `country`)
values ('customer 1', '123', 'DN', 'DN'),
		('customer 2', '456', 'HN', 'HN'), 
		('customer 3', '789', 'HCM', 'HCM');
        
update customers set `country` = 'QN' where `idcustomers` = 3;

select `customername`, `phone`, `city`, `country` from `customers` ;

SELECT * FROM customers WHERE customerName = 'customer 3';

SELECT customername FROM customers WHERE customername like '%cus%';

update customers set `customername` = 'thanh' where `idcustomers` = 3; 

update customers set `customername` = 'cong' where `idcustomers` = 2; 

select * from customers where customername in ('thanh','cong');

select * from customers;