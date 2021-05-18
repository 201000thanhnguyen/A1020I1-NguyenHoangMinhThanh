drop database if exists demo1;
create database demo1;
use demo1;

create table products(
id int,
productCode varchar(10),
productName varchar(10),
productPrice double,
productAmount int,
productDescription text,
productStatus varchar(100)
);

insert into products
values
(1, 'A01', '7up', 5000, 100, 'Hàng Tồn Kho', 'Còn Hàng'),
(2, 'B02', 'coca', 6000, 100, 'Hàng Tồn Kho', 'Còn Hàng'),
(3, 'C03', 'pepsi', 60000, 100, 'Hàng Tồn Kho', 'Còn Hàng'),
(4, 'D04', 'revive', 10000, 100, 'Hàng Tồn Kho', 'Còn Hàng'),
(5, 'E05', '0 độ', 90000, 100, 'Hàng Tồn Kho', 'Còn Hàng');

explain select *
from products
where productCode = 'A01' ; 


select * 
from products
where productCode = 'E05';

create unique index idx_product_code
on products (productCode);

create index idx_products_composite 
on products (productName,productPrice);

explain select *
 from products
 where productCode = 'A01';


create view view_products
as
select productName, productCode, productPrice, productStatus
from products;
select * from view_products;	

update view_products
set 
productName = 'sting dâu'
where productCode = 'A01';

select*from view_products ;

delete from view_products
where productCode= 'A01';
select*from view_products ;

drop view view_products;


DELIMITER //

create procedure sp_products()
begin
select * from products;
end 

// DELIMITER ;

call sp_products();

DELIMITER //
create procedure sp_products1
(id int,
productCode varchar(10),
productName varchar(10),
productPrice double,
productAmount int,
productDescription text,
productStatus varchar(100)
)
begin
	insert into products
    values
    (id, productCode,productName,productPrice, productAmount, productDescription,productStatus);
end;
// DELIMITER ;

call sp_products1(6,'S01','Laru',10000, 100,'Hàng Tồn Kho','Còn Hàng');

DELIMITER //
create procedure sp_products2
(in p_id int,
p_productCode varchar(10),
p_productName varchar(10),
p_productPrice double,
p_productAmount int,
p_productDescription text,
p_productStatus varchar(100)
)
begin
	update products
    set productCode = p_productCode, productName = p_productName,productPrice = p_productPrice, 
    productAmount = p_productAmount, productDescription = p_productDescription,productStatus = p_productStatus
    where id = p_id;
end;
// DELIMITER ;

call sp_products2(2,'M01','Huda', 11000, 50, 'Hàng Xách Tay', 'Hết Hàng');


DELIMITER //
create procedure sp_delete(in p_id int)
begin
	delete from products 
    where id = p_id;
end;
// DELIMITER ;
call sp_delete(2);