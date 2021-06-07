drop database if exists db_BookStore;
create database db_BookStore;
use db_BookStore;

create table Book(
	bookId int auto_increment primary key,
    bookName varchar(255),
    bookCreateDate date
);

insert into Book
values 
	(null, "book 1", "2001/01/02"),
	(null, "book 2", "2002/01/02"),
	(null, "book 3", "2003/01/02");
    
-- select * from Book;