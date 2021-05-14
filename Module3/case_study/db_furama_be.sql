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
    userName varchar(255),
    
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
    customerGender bit(1),
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















