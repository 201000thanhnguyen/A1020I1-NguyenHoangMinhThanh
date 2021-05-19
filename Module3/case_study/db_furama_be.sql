drop database if exists db_furama_be;
create database db_furama_be;
use db_furama_be;

create table Position (
	positionId int primary key auto_increment,
    positionName varchar(255)
);

create table EducationDegree (
	educationDegreeId int primary key auto_increment,
    educationDegreeName varchar(255)
);

create table Division (
	divisionId int primary key auto_increment,
    divisionName varchar(255)
);

create table Users (
	userName varchar(255) primary key,
    userPassword varchar(255)
);

create table Roles (
	roleId int primary key auto_increment,
    roleName varchar(255)
);

create table UserRole (
	roleId int,
    userName varchar(255),
    primary key (roleId, userName),
    constraint fk_ur_rl foreign key (roleId) references Roles (roleId),
    constraint fk_ur_us foreign key (userName) references Users (userName)
);

create table CustomerType (
	customerTypeId int primary key auto_increment,
    customerTypeName varchar(255)
);

create table ServiceType (
	serviceTypeId int primary key auto_increment,
    serviceTypeName varchar(255)
);

create table RentType (
	rentTypeId int primary key auto_increment,
    rentTypeName varchar(255),
    rentTypeCost double
);


create table Employee (
	employeeId int primary key auto_increment,
    employeeName varchar(255),
    employeeBirthday date,
    employeeIdCard varchar(255),
    employeeSalary double,
    employeePhone varchar(255),
    employeeEmail varchar(255),
    employeeAddress varchar(255),
    positionId int,
    educationDegreeId int,
    divisionId int,
    userName varchar(255) unique,
    
    constraint fk_em_po foreign key (positionId) references Position (positionId),
    constraint fk_em_ed foreign key (educationDegreeId) references EducationDegree (educationDegreeId),
    constraint fk_em_di foreign key (divisionId) references Division (divisionId),
    constraint fk_em_us foreign key (userName) references Users (userName)
);

create table Customer (
	customerId int primary key auto_increment,
    customerTypeId int,
    customerName varchar(255),
    customerBirthday date,
    customerGender int,
    customerIdCard varchar(255),
    customerPhone varchar(255),
    customerEmail varchar(255),
    customerAddress varchar(255),
    
    constraint fk_cu_cuT foreign key (customerTypeId) references CustomerType (customerTypeId)
);

create table Service (
	serviceId int primary key auto_increment,
    serviceName varchar(255),
    serviceArea int,
    serviceCost double,
    serviceMaxPeople int,
    rentTypeId int,
    serviceTypeId int,
    standardRoom varchar(255),
    descOtherConvenience varchar(255),
    poolArea double,
    numberOfFloors int,
    
    constraint fk_se_re foreign key (rentTypeId) references RentType (rentTypeId),
    constraint fk_se_seT foreign key (serviceTypeId) references ServiceType (serviceTypeId)
);

create table Contract (
	contractId int primary key auto_increment,
    contractStartDate datetime,
    contractEndDate datetime,
    contractDeposit double,
    contractTotalMoney double,
    employeeId int,
    customerId int,
    serviceId int,
    
    constraint fk_co_em foreign key (employeeId) references Employee (employeeId),
    constraint fk_co_cu foreign key (customerId) references Customer (customerId),
    constraint fk_co_se foreign key (serviceId) references Service (serviceId)
);

create table AttachService (
	attachServiceId int primary key auto_increment,
    attachServiceName varchar(255),
    attachServiceCost double,
    attachServiceUnit int,
    attachServiceStatus varchar(255)
);

create table ContractDetail (
	contractDetailId int primary key auto_increment,
    contractId int,
    attachServiceId int,
    quantity int,
    
    constraint fk_coD_co foreign key (contractId) references Contract (contractId),
    constraint fk_coD_at foreign key (attachServiceId) references AttachService (attachServiceId)
);


-- template data

insert into AttachService (attachServiceName, attachServiceCost, attachServiceUnit)
	values 
		('massage','300000','1'),
        ('karaoke','200000','1'),
        ('thức ăn','100000','1'),
        ('nước uống','20000','1'),
        ('thuê xe di chuyển tham quan resort','300000','1');
        
insert into EducationDegree (educationDegreeName)
	values 
		('Trung cấp'),
		('Cao đẳng'),
		('Đại học'),
		('Sau Đại Học');
        
insert into Position (positionName)
	values 
		('Lễ tân'),
		('phục vụ'),
		('chuyên viên'),
		('giám sát'),
		('quản lý'),
		('giám đốc');
        
insert into Division (divisionName)
	values
		('Sale – Marketing'),
		('Hành Chính'),
		('Phục vụ'),
		('Quản lý');

insert into Roles (roleName)
	values
		('roleDetail'),
		('roleAdd'),
        ('roleEdit'),
        ('roleDelete'),
        ('rolePermission');

insert into Users
values
	("admin", "admin"),
	("user", "user");

insert into UserRole
	values
		('1', 'admin'),
		('2', 'admin'),
		('3', 'admin'),
		('4', 'admin'),
		('5', 'admin');

insert into Employee
		(employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, userName)
	values 
		("emp 1","1999-1-1","123456789","9000000","01201234567","emp1@gmail.com","Mỹ","5","4","4","admin"),
		("emp 2","2000-2-2","923456789","6000000","01201234987","emp2@gmail.com","Úc","1","2","3","user");

insert into CustomerType (customerTypeName)
	values
		('Diamond'),
		('Platinium'),
		('Gold'),
		('Silver'),
		('Member');

insert into Customer 
	values
		(null, '1', 'cus 1', '1998-01-02', '1', '123454321', '0935353535', 'cus1@gmail.com', 'Mỹ'),
		(null, '2', 'cus 11', '1998-01-02', '0', '123454321', '0935353535', 'cus1@gmail.com', 'Mỹ'),
		(null, '3', 'cus 12', '1998-01-02', '0', '123454321', '0935353535', 'cus1@gmail.com', 'Mỹ'),
		(null, '4', 'cus 13', '1998-01-02', '0', '123454321', '0935353535', 'cus1@gmail.com', 'Mỹ'),
		(null, '5', 'cus 14', '1998-01-02', '1', '123454321', '0935353535', 'cus1@gmail.com', 'Mỹ'),
		(null, '4', 'cus 15', '1998-01-02', '0', '123454321', '0935353535', 'cus1@gmail.com', 'Mỹ'),
		(null, '3', 'cus 16', '1998-01-02', '0', '123454321', '0935353535', 'cus1@gmail.com', 'Mỹ'),
		(null, '2', 'cus 17', '1998-01-02', '1', '123454321', '0935353535', 'cus1@gmail.com', 'Mỹ'),
		(null, '1', 'cus 18', '1998-01-02', '1', '123454321', '0935353535', 'cus1@gmail.com', 'Mỹ'),
		(null, '2', 'cus 19', '1998-01-02', '1', '123454321', '0935353535', 'cus1@gmail.com', 'Mỹ'),
		(null, '3', 'cus 2', '2002-11-09', '0', '123454399', '0935353599', 'cus2@gmail.com', 'Canada');

insert into ServiceType (serviceTypeName)
	values
		('Villa'),
		('House'),
		('Room');
        
insert into RentType (rentTypeName, rentTypeCost)
	values
		('năm','360000000'),
		('tháng','30000000'),
		('ngày','2400000'),
		('giờ','600000');

insert into Service
		(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descOtherConvenience, poolArea, numberOfFloors)
	values
		('Villa', '1000', '300000', '10', '2', '1', 'Vip', 'none', '50', '2'),
		('House', '800', '200000', '10', '2', '2', 'Vip', 'none', '30', '3');

insert into Contract 
		(contractStartDate, contractEndDate, contractDeposit, contractTotalMoney, employeeId, customerId, serviceId)
	values
		('2012-01-01','2012-02-01','310000000','300000000','1','1','1'),
		('2013-01-01','2013-02-01','310000000','300000000','2','2','2');

insert into AttachService 
		(attachServiceName, attachServiceCost, attachServiceUnit, attachServiceStatus)
	values
		('massage', '300000', '1', 'được sử dụng'),
		('karaoke', '300000', '1', 'được sử dụng'),
		('thức ăn', '100000', '1', 'được sử dụng'),
		('nước uống', '20000', '1', 'được sử dụng'),
		('thuê xe di chuyển tham quan resort', '300000', '1', 'được sử dụng');

insert into ContractDetail 
		(contractId, attachServiceId, quantity)
	values
		('1', '3', '60'),
		('1', '1', '10'),
		('1', '5', '10'),
		('1', '4', '60'),
		('2', '3', '60'),
		('2', '4', '60');

-- test query

-- select cu.*, cuT.customerTypeName from Customer cu inner join CustomerType cuT on cu.customerTypeId = cuT.customerTypeId

DELIMITER //

create procedure sp_count_customer()
begin
select count(*) as numberCustomer from Customer;
end 

// DELIMITER ;

DELIMITER //

create procedure sp_limit_customer(in _index int, in _getNumber int)
begin
select cu.*, cuT.customerTypeName from Customer cu inner join CustomerType cuT on cu.customerTypeId = cuT.customerTypeId order by cu.customerId ASC limit _index,_getNumber;
end 

// DELIMITER ;

call sp_limit_customer(0,10);








