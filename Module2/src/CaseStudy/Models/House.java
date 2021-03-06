package CaseStudy.Models;

public class House extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private int soTang;

    public House() {
    }

    public House(String id, String tenDichVu, int dienTichSuDung, int chiPhiThue, int soLuongNguoi, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, int soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaTienNghiKhac() {
        return moTaTienNghiKhac;
    }

    public void setMoTaTienNghiKhac(String moTaTienNghiKhac) {
        this.moTaTienNghiKhac = moTaTienNghiKhac;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public void showInfor() {
        System.out.println(
                "\nId: " + getId() +
                "\nTên dịch vụ: " + getTenDichVu() +
                "\nDiện tích sử dụng " + getDienTichSuDung() +
                "\nChi phí thuê: " + getChiPhiThue() +
                "\nSố lượng người tối đa: " + getSoLuongNguoi() +
                "\nKiểu thuê: " + getKieuThue() +
                "\nTiêu chuẩn phòng: " + getTieuChuanPhong() +
                "\nMô tả tiện nghi khác: " + getMoTaTienNghiKhac() +
                "\nSố tầng: " + getSoTang());
    }

    @Override
    public String toString() {
        return "\n\tId: " + getId() +
                "\n\tTên dịch vụ: " + getTenDichVu() +
                "\n\tDiện tích sử dụng " + getDienTichSuDung() +
                "\n\tChi phí thuê: " + getChiPhiThue() +
                "\n\tSố lượng người tối đa: " + getSoLuongNguoi() +
                "\n\tKiểu thuê: " + getKieuThue() +
                "\n\tTiêu chuẩn phòng: " + getTieuChuanPhong() +
                "\n\tMô tả tiện nghi khác: " + getMoTaTienNghiKhac() +
                "\n\tSố tầng: " + getSoTang();
    }
}
