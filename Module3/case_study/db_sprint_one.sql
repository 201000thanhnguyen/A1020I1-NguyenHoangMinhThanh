drop database if exists db_sprint_one;
create database db_sprint_one;
use db_sprint_one;

create table Customer(
	id int primary key,
	full_name varchar(255),
    username varchar(255),
    `password` varchar(255),
    date_of_birth date,
    email varchar(255),
    phone varchar(255),
    address varchar(255),
    `status` boolean
);

create table Service(
	service_id nvarchar(255) primary key,
    service_name nvarchar(255),
    unit nvarchar(255),
    quantity int,
    prices int,
    image nvarchar(255)
);

create table OrderService(
	id int,
    service_id nvarchar(255),
    quantity int,
    unit nvarchar(255),
    total_money int,
    foreign key (id) references Customer(id),
    foreign key (service_id) references Service(service_id),
    primary key(id, service_id)
);