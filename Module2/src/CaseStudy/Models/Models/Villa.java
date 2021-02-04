package CaseStudy.Models.Models;

public class Villa extends Services {

    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private double dienTichHoBoi;
    private int soTang;

    public Villa(){

    }

    public Villa(String tieuChuanPhong, String moTaTienNghiKhac, double dienTichHoBoi, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Villa(String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String id, String tieuChuanPhong, String moTaTienNghiKhac, double dienTichHoBoi, int soTang) {
        super(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, id);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
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

    public double getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(double dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
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
                        "Villa{" +
                        "tieuChuanPhong= '" + tieuChuanPhong + '\'' +
                        ", moTaTienNghiKhac= '" + moTaTienNghiKhac + '\'' +
                        ", dienTichHoBoi= " + dienTichHoBoi +
                        ", soTang= " + soTang +
                        ", tenDichVu='" + getTenDichVu() + '\'' +
                        ", dienTichSuDung=" + getDienTichSuDung() +
                        ", chiPhiThue=" + getChiPhiThue() +
                        ", soLuongNguoiToiDa=" + getSoLuongNguoiToiDa() +
                        ", kieuThue='" + getKieuThue() + '\'' +
                        ", id='" + getId() + '\'' +
                        '}');
    }

}
