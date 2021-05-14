drop database if exists test;
create database test;
use test;

create table users (
	userName varchar(50) primary key,
    userPassword varchar(50)
);

create table roles (
	roleId int primary key,
    roleName varchar(50)
);

create table users_roles(
	roleId int,
    userName varchar(50),
    primary key (roleId, userName),
    constraint users_roles_roles foreign key (roleId) references roles (roleId),
    constraint users_roles_users foreign key (userName) references users (userName)
);