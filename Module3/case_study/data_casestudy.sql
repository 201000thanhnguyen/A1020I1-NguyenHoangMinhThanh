use db_furama;
insert into ViTri (TenViTri) 
	values ('Lễ Tân'), ('Phục Vụ'), ('Chuyên Viên'), ('Giám Sát'), ('Quản Lý'), ('Giám Đốc');
    
insert into TrinhDo (TrinhDo)
	values ('Trung Cấp'), ('Cao Đẳng'), ('Đại Học'), ('Sau Đại Học');
    
insert into BoPhan (TenBoPhan)
	values ('Sale – Marketing'), ('Hành Chính'), ('Phục vụ'), ('Quản lý');
    
insert into LoaiKhach (TenLoaiKhach)
	values ('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Member');
    
insert into KieuThue (TenKieuThue)
	values ('năm'), ('tháng'), ('ngày'), ('giờ');
    
insert into LoaiDichVu (TenLoaiDichVu)
	values ('Villa'), ('House'), ('Room');
    
insert into DichVuDiKem 
		(TenDichVuDiKem,Gia,DonVi)
	values 
		('massage','15','1'), 
        ('karaoke','20','1'), 
        ('thức ăn','3','1'), 
        ('nước uống','1','1'), 
        ('thuê xe di chuyển tham quan resort','40','1');
    
insert into NhanVien
		(HoTen,IDViTri,IDTrinhDo,IDBoPhan,NgaySinh,SoCMTND,Luong,SDT,Email,DiaChi)
	values
		('Hữu Khánh','1','1','3','1960-1-1','201800001','300','0701597535','khanh@gmail.com','Đà Nẵng'),
		('Lê Thế Trung','2','2','2','1990-2-2','201800002','600','0703579515','trung@gmail.com','Quảng Bình'),
		('Ngô Hiền Nhân','3','3','1','1999-3-3','201920466','500','0702586431','nhan@gmail.com','Quảng Trị'),
		('Anh Dũng','4','4','2','2002-4-4','203697455','600','0856248797','dung@gmail.com','Hồ Chí Minh'),
		('Đỗ Viết Đăng Khoa','5','3','3','2005-5-5','206549877','300','0706984125','khoa@gmail.com','Hà Nội'),
		('Hoàng Ngọc Cường','6','2','4','2000-9-9','201450688','4000','0704679825','cuong@gmail.com','Nghệ An');
        
insert into KhachHang
		(IDLoaiKhach,HoTen,NgaySinh,SoCMTND,SDT,Email,DiaChi)
    Values
		('1','Phạm Thanh Tùng','1999-6-6','201987412','0935356545','tung@gmail.com','Đà Nẵng'),
		('2','Đoàn Thị Mai','1994-7-7','201986325','0908474866','mai@gmail.com','Quảng Nam'),
		('3','Hồ Đức Thắng','2003-8-8','201945687','0935469874','thang@gmail.com','Quảng Ngãi'),
		('4','Nguyễn Văn Điềm','1990-10-10','202014256','0120203654','diem@gmail.com','Thái Bình'),
		('5','Mai Văn Đạt','1980-11-11','202074512','0120696988','dat@gmail.com','Cà Mau'),
		('5','Minh Thành','1970-12-12','201896333','01201234567','thanh@gmail.com','Đồng Tháp');
        
insert into DichVu
		(TenDichVu,DienTich,SoTang,SoNguoiToiDa,ChiPhiThue,IDKieuThue,IDLoaiDichVu,TrangThai)
	values
		('Luxury Furama Dana Villa','300','3','35','400','3','1','đang hoạt động'),
		('TIA Wellness Resort','260','2','30','390','3','1','sẵn sàng'),
		('Furama Resort Danang','265','2','30','380','2','2','sẵn sàng'),
		('Jang House','230','5','20','70','4','2','đang hoạt động'),
		('Him Lam Apartment','255','2','20','320','2','3','sẵn sàng');

insert into HopDong
		(IDNhanVien,IDKhachHang,IDDichVu,NgayLamHopDong,NgayKetThuc,TienDatCoc,TongTien)
	values
		(3, 5, 1, '2020-4-28', '2030-7-28', 17000, 56000),
		(4, 1, 3, '2018-6-12', '2035-5-21', 26000, 80000),
		(6, 3, 2, '2019-10-20', '2040-6-12', 20000, 85000),
		(1, 3, 2, '2019-10-20', '2040-6-12', 20000, 85000),
		(5, 1, 2, '2019-10-20', '2040-6-12', 25000, 70000),
		(2, 5, 1, '2020-4-28', '2030-7-28', 27000, 72000);
	
insert into HopDongChiTiet
		(IDHopDong,IDDichVuDiKem,SoLuong)
	values
		('1','1','99'),
		('2','2','98'),
		('3','3','97'),
		('4','4','96'),
		('5','5','95'),
		('6','4','94');
