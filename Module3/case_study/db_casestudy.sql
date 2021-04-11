drop database if exists db_furama;
create database db_furama;
use db_furama;
create table ViTri(
	IDViTri int primary key auto_increment,
    TenViTri varchar(45)
);
create table TrinhDo(
	IDTrinhDo int primary key auto_increment,
    TrinhDo varchar(45)
);
create table BoPhan(
	IDBoPhan int primary key auto_increment,
    TenBoPhan varchar(45)
);
create table LoaiKhach(
	IDLoaiKhach int primary key auto_increment,
    TenLoaiKhach varchar(45)
);
create table KieuThue(
	IDKieuThue int primary key auto_increment,
    TenKieuThue varchar(45),
    Gia int
);
create table LoaiDichVu(
	IDLoaiDichVu int primary key auto_increment,
    TenLoaiDichVu varchar (45)
);
create table DichVuDiKem(
	IDDichVuDiKem int primary key auto_increment,
    TenDichVuDiKem varchar(45),
    Gia int,
    DonVi int,
    TrangThaiKhaDung varchar(45)
);
create table NhanVien(
	IDNhanVien int primary key auto_increment,
    HoTen varchar(45),
    IDViTri int,
    IDTrinhDo int,
    IDBoPhan int,
    NgaySinh date,
    SoCMTND varchar(45),
    Luong varchar(45),
    SDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45),
    
    constraint fk_nv_vt
		foreign key (IDViTri)
        references ViTri (IDVitri),
	constraint fk_nv_td
		foreign key (IDTrinhDo)
        references TrinhDo (IDTrinhDo),
	constraint fk_nv_bp
		foreign key (IDBoPhan)
        references BoPhan (IDBoPhan)
);
create table KhachHang(
	IDKhachHang int primary key auto_increment,
    IDLoaiKhach int,
    HoTen varchar(45),
    NgaySinh date,
    SoCMTND varchar(45),
    SDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45),
    
    constraint fk_kh_lk
		foreign key (IDLoaiKhach)
        references LoaiKhach (IDLoaiKhach)
);
create table DichVu(
	IDDichVu int primary key auto_increment,
    TenDichVu varchar(45),
    DienTich double,
    SoTang int,
    SoNguoiToiDa int,
    ChiPhiThue double,
    IDKieuThue int,
    IDLoaiDichVu int,
    TrangThai varchar(45),
    
    constraint fk_dv_kt
		foreign key (IDKieuThue)
        references KieuThue (IDKieuThue),
	constraint fk_dv_ldv
		foreign key (IDLoaiDichVu)
        references LoaiDichVu (IDLoaiDichVu)
);
create table HopDong(
	IDHopDong int primary key auto_increment,
    IDNhanVien int,
    IDKhachHang int,
    IDDichVu int,
    NgayLamHopDong date,
    NgayKetThuc date,
    TienDatCoc double,
    TongTien double,
    
    constraint fk_hd_nv
		foreign key (IDNhanVien)
        references NhanVien (IDNhanVien),
	constraint fk_hd_kh
		foreign key (IDKhachHang)
        references KhachHang (IDKhachHang),
	constraint fk_hd_dv
		foreign key (IDDichVu)
        references DichVu (IDDichVu)
);
create table HopDongChiTiet(
	IDHopDongChiTiet int primary key auto_increment,
    IDHopDong int,
    IDDichVuDiKem int,
    SoLuong int,
    
    constraint fk_hdct_dvdk
		foreign key (IDDichVuDiKem)
        references DichVuDiKem (IDDichVuDiKem),
	constraint fk_hdct_hd
		foreign key (IDHopDong)
        references HopDong (IDHopDong)
);

