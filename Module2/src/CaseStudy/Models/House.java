package CaseStudy.Models;

public class House extends Services {

    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private int soTang;

    public House(){

    }

    public House(String tieuChuanPhong, String moTaTienNghiKhac, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.soTang = soTang;
    }

    public House(String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String id, String tieuChuanPhong, String moTaTienNghiKhac, int soTang) {
        super(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue, id);
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
                        "House{" +
                        "tieuChuanPhong= '" + tieuChuanPhong + '\'' +
                        ", moTaTienNghiKhac= '" + moTaTienNghiKhac + '\'' +
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
