drop database if exists demo;
CREATE DATABASE demo;
USE demo;

create table users (
 id int primary key AUTO_INCREMENT,
 nameUser varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120)
);

insert into users(nameUser, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(nameUser, email, country) values('Kante','kante@che.uk','Kenia');

DELIMITER //
create procedure sp_select_user()
begin
select * from users;
end 
// DELIMITER ;

DELIMITER //
create procedure sp_edit_user(in _id int, _nameUser varchar(255), _email varchar(255), _country varchar(255))
begin
update users set nameUser = _nameUser, email = _email, country = _country where id = _id ;
end 
// DELIMITER ;

DELIMITER //
create procedure sp_delete_user(in _id int)
begin
	delete from users 
    where id = _id;
end;
// DELIMITER ;

-- call sp_edit_user(2, 'thành', 'thanh@gmail.com', 'America');

-- call sp_delete_user(2);

-- call sp_select_user();

-- update users set nameUser = 'nameUser', email = 'email', country = 'country' where `id`= 2;