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
    
insert into DichVuDiKem (TenDichVuDiKem)
	values ('massage'), ('karaoke'), ('thức ăn'), ('nước uống'), ('thuê xe di chuyển tham quan resort');
    
insert into NhanVien
		(HoTen,IDViTri,IDTrinhDo,IDBoPhan,NgaySinh,SoCMTND,Luong,SDT,Email,DiaChi)
	values
		('Hữu Khánh','1','1','3','1960-1-1','201800001','300','0701597535','khanh@gmail.com','10 Quang Trung'),
		('Lê Thế Trung','2','2','2','1990-2-2','201800002','600','0703579515','trung@gmail.com','55 Lê Đình Lý'),
		('Ngô Hiền Nhân','3','3','1','1999-3-3','201920466','500','0702586431','nhan@gmail.com','299 Ông Ích Đường'),
		('Anh Dũng','4','4','2','2002-4-4','203697455','600','0856248797','dung@gmail.com','70 Hoàng Diệu'),
		('Đỗ Viết Đăng Khoa','5','3','3','2005-5-5','206549877','300','0706984125','khoa@gmail.com','1 Đóng Đa'),
		('Hoàng Ngọc Cường','6','2','4','2000-9-9','201450688','4000','0704679825','cuong@gmail.com','177 Trưng Nữ Vương');
        
insert into KhachHang
		(IDLoaiKhach,HoTen,NgaySinh,SoCMTND,SDT,Email,DiaChi)
    Values
		('1','Phạm Thanh Tùng','1999-6-6','201987412','0935356545','tung@gmail.com','23 Lê Văn Duyệt'),
		('2','Đoàn Thị Mai','1994-7-7','201986325','0908474866','mai@gmail.com','9 Võ Chí Công'),
		('3','Hồ Đức Thắng','2003-8-8','201945687','0935469874','thang@gmail.com','9 Ông Ích Khiêm'),
		('4','Nguyễn Văn Điềm','1990-10-10','202014256','0120203654','diem@gmail.com','40 Lý Thái Tổ'),
		('5','Mai Văn Đạt','1980-11-11','202074512','0120696988','dat@gmail.com','11 Điện Biên Phủ'),
		('5','Minh Thành','1970-12-12','201896333','01201234567','thanh@gmail.com','41 Lê Duẩn');
        
insert into DichVu
		(TenDichVu,DienTich,SoTang,SoNguoiToiDa,ChiPhiThue,IDKieuThue,IDLoaiDichVu,TrangThai)
	values
		('Luxury Furama Dana Villa','300','3','35','400','3','',''),
		('TIA Wellness Resort','260','2','30','390','3','',''),
		('Furama Resort Danang','265','2','30','380','','',''),
		('Jang House','230','5','20','70','4','',''),
		('Him Lam Apartment','255','2','20','320','','','');