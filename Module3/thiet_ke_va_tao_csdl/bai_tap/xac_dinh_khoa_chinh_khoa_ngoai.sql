drop database if exists db_taokhoangoai;
create database db_xacdinhkhoa;
use db_xacdinhkhoa;
create table customers (
	customer_number int primary key auto_increment,
    fullname varchar(50),
    address varchar(50),
    email varchar(50),
    phone varchar(50)
);
create table accounts (
	account_number int primary key,
    account_type varchar(50),
    account_date date,
    balance double,
    
    customer_account int,
    constraint fk_accounts_customers
    foreign key (customer_account) references customers (customer_number)
);

create table Transactions (
	tran_number int primary key auto_increment,
    code_account int,
    tran_date date,
    amounts double,
    descriptions varchar(50),
    
    account_transaction int,
    constraint fk_transactions_accounts
    foreign key (account_transaction) references accounts (account_number)
);