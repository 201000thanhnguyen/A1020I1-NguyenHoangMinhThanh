drop database if exists db_TComplex;
create database db_TComplex;
use db_TComplex;

create table GroundStatus(
	groundStatusId int auto_increment primary key,
    groundStatusName varchar(255)
);

create table GroundType(
	groundTypeId int auto_increment primary key,
    groundTypeName varchar(255)
);

create table Ground(
	groundId varchar(255) primary key,
    groundStatusId int,
    groundAcreage double,
    groundFloor int,
    groundTypeId int,
    groundCost double,
    groundStartDate date,
    groundEndDate date,
    
    constraint fk_gr_grS foreign key (groundStatusId) references GroundStatus (groundStatusId),
    constraint fk_gr_grT foreign key (groundTypeId) references GroundType (groundTypeId)
);

insert into GroundStatus
values
	(null, "trống"),
	(null, "Hạ Tầng"),
	(null, "Đầy đủ");
    
insert into GroundType
values
	(null, "Văn phòng"),
	(null, "Văn phòng chia sẻ"),
	(null, "Văn phòng trọn gói");
    
insert into Ground
values
	("0000-00-01", 1, 30, 2, 1, 2000000, "2020-10-10", "2021-10-10"),
	("0000-00-02", 2, 40, 1, 1, 2100000, "2019-10-09", "2020-10-10"),
	("0000-00-03", 3, 50, 3, 1, 2200000, "2018-10-08", "2019-10-10");
    
select gr.*, grS.groundStatusName, grT.groundTypeName from Ground gr
inner join GroundStatus grS on gr.groundStatusId = grS.groundStatusId  
inner join GroundType grT on gr.groundTypeId = grT.groundTypeId order by gr.groundAcreage asc;  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    