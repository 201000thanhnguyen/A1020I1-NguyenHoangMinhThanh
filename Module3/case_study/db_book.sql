drop database if exists db_book;
create database db_book;
use db_book;

create table Book(
	bookId int auto_increment primary key,
    bookName varchar(255),
    bookType varchar(255),
    bookCreateDate date
);

insert into Book
values 
	(null, "book 1", "haha", "2001/01/02"),
	(null, "book 2", "hihi", "2002/01/02"),
	(null, "book 3", "hoho, haha", "2003/01/02");
    
-- select * from Book;