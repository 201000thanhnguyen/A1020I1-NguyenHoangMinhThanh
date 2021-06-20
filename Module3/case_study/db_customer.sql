drop database if exists db_customer;
create database db_customer;
use db_customer;

create table Customer(
	customerId int auto_increment primary key,
    customerName varchar(255),
    customerLanguage varchar(255),
    customerBirthday date
);

insert into Customer
values 
	(null, "cus 1", "VN", "2001/01/02"),
	(null, "cus 2", "EN", "2002/01/02"),
	(null, "cus 3", "VN, EN", "2003/01/02");
    
-- select * from Customer;