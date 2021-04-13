use db_furama;

-- cau 2
select * 
from NhanVien
where (HoTen like 'H%' or HoTen like 'T%' or HoTen like 'K%') and length(HoTen) <= 15;

-- cau3
select * 
from KhachHang
where (DiaChi Like 'Đà Nẵng' or DiaChi = 'Quảng Trị') and ((year(current_date()) - year(NgaySinh)) <=50) and ((year(current_date()) - year(NgaySinh)) >= 18);

-- cau 4
select kh.HoTen, count(IDHopDong) 'Lần đặt phòng'
from KhachHang kh inner join HopDong hd 
on kh.IDKhachHang = hd.IDKhachHang
inner join Loaikhach lk
on kh.IDLoaikhach = lk.IDLoaikhach where TenLoaikhach = 'Diamond'
group by kh.IDKhachHang
order by count(hd.IDKhachHang) desc;

-- cau 5
select kh.IDKhachHang, kh.HoTen, lkh.TenLoaikhach, hd.IDHopDong, dv.TenDichVu, hd.NgayLamHopDong, hd.NgayKetThuc, sum(dv.ChiPhiThue + dvdk.Donvi * dvdk.Gia) 'TongTien'
from KhachHang kh inner join Loaikhach lkh
on kh.IDLoaikhach = lkh.IDLoaikhach
inner join HopDong hd
on hd.IDKhachHang = kh.IDKhachHang
inner join DichVu dv
on dv.IDDichVu = hd.IDDichVu
inner join HopDongChiTiet hdct
on hd.IDHopDong = hdct.IDHopDong
inner join DichVuDiKem dvdk
on dvdk.IDDichVuDiKem = hdct.IDDichVuDiKem
group by hd.IDHopDong;

-- câu 6
select dv.IDDichVu, dv.TenDichVu, dv.DienTich, dv.ChiPhiThue, ldv.TenLoaiDichVu
from DichVu dv
inner join LoaiDichVu ldv on dv.IDLoaiDichVu = ldv.IDLoaiDichVu
inner join HopDong hd on dv.IDDichVu =  hd.IDDichVu
where  NgayLamHopDong not in(
select NgayLamHopDong
from HopDong
where NgayLamHopDong between '2019-01-01' and '2019-03-31'
);

-- yêu cầu 7
select dv.IDDichVu, dv.TenDichVu, dv.DienTich, dv.SoNguoiToiDa, dv.ChiPhiThue, ldv.TenLoaiDichVu
from DichVu dv
inner join HopDong hd on dv.IDDichVu = hd.IDDichVu
inner join loaiDichVu ldv on dv.IDLoaiDichVu = ldv.IDLoaiDichVu
where hd.IDDichVu not in (
select IDDichVu
from HopDong
where year(NgayLamHopDong) = '2019'
) and hd.IDDichVu in (select IDDichVu
from HopDong
where year(NgayLamHopDong) = '2018');

-- yêu cầu 8 -- chưa nghỉ ra loại 3
select distinct kh.HoTen
from KhachHang kh;

select HoTen
from KhachHang kh
group by kh.HoTen;

-- yêu cầu 9
select IDHopDong, TongTien
from HopDong
where year(NgayLamHopDong) = '2019';

-- yêu cầu 10
select hd.IDHopDong, hd.NgayLamHopDong, hd.NgayKetThuc, hd.TienDatCoc, count(hdct.IDHopDongChiTiet) as SodvDaDung
from HopDong hd
left join HopDongChiTiet hdct on hd.IDHopDong = hdct.IDHopDong
left join DichVuDiKem dvdk on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
group by hd.IDHopDong;

-- yêu cầu 11
select dvdk.IDDichVuDiKem,TenDichVuDiKem,Gia,Donvi,TrangThaikhaDung
from KhachHang kh 
inner join HopDong hd on kh.IDKhachHang = hd.IDKhachHang
inner join HopDongChiTiet hdct on hd.IDHopDong = hdct.IDHopDong
inner join DichVuDiKem dvdk on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
where kh.DiaChi = 'Quảng Ngãi' or kh.DiaChi = 'Vinh';

-- yêu cầu 12
select hd.IDHopDong,TienDatCoc,NgayLamHopDong,nv.HoTen, kh.IDKhachHang,kh.HoTen,kh.SDT,
dv.IDDichVu,TenDichVu,sum(hdct.SoLuong) as SoLuong
from HopDong hd
inner join KhachHang kh on  hd.IDKhachHang = kh.IDKhachHang
inner join NhanVien nv on hd.IDNhanVien = nv.IDNhanVien
inner join DichVu dv on hd.IDDichVu = dv.IDDichVu
inner join HopDongChiTiet hdct on hd.IDHopDong = hdct.IDHopDong
where hd.IDHopDong in(
select IDHopDong
from HopDong
where NgayLamHopDong between '2019-10-01' and '2019-12-31');

-- yêu cầu 13
select hdct.IDDichVuDiKem,TenDichVuDiKem,max(hdct.SoLuong)
from DichVuDiKem dvdk
inner join HopDongChiTiet hdct on dvdk.IDDichVuDiKem = hdct.IDDichVuDiKem
group by hdct.IDDichVuDiKem
order by SoLuong desc
limit 3;	

-- yêu cầu 14
select hd.IDHopDong, ldv.TenLoaiDichVu, dvdk.TenDichVuDiKem
from HopDong hd
left join DichVu dv on hd.IDDichVu = dv.IDDichVu
left join loaiDichVu ldv on dv.IDLoaiDichVu = ldv.IDLoaiDichVu
left join HopDongChiTiet hdct on hd.IDHopDong = hdct.IDHopDong
left join DichVuDiKem dvdk on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
where hdct.SoLuong = 1;

-- yêu cầu 15
select nv.IDNhanVien,HoTen,SDT,DiaChi, td.TrinhDo, bp.TenBoPhan,count(HopDong.IDHopDong) SoLanLapHD
from HopDong 
inner join NhanVien nv on HopDong.IDNhanVien = nv.IDNhanVien
inner join TrinhDo td on nv.IDTrinhDo = td.IDTrinhDo
inner join BoPhan bp on nv.IDBoPhan = bp.IDBoPhan
where year(NgayLamHopDong) between '2018' and '2019'
group by HopDong.IDNhanVien
having SoLanLapHD = 3;

-- yêu cầu 16 (fail)
delete from NhanVien nv
where IDNhanVien not in (
select nv.IDNhanVien from HopDong hd where hd.NgayLamHopDong >= "2017-1-1" and hd.NgayLamHopDong < "2019-12-31" and nv.IDNhanVien is not null );
        
-- yêu cầu 18
