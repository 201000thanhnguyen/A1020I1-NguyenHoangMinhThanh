package CaseStudy.Models;

public abstract class Services {
    private String id;
    private String tenDichVu;
    private int dienTichSuDung;
    private int chiPhiThue;
    private int soLuongNguoi;
    private String kieuThue;

    public Services(){
    }

    public Services(String id, String tenDichVu, int dienTichSuDung, int chiPhiThue, int soLuongNguoi, String kieuThue) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTichSuDung;
        this.chiPhiThue = chiPhiThue;
        this.soLuongNguoi = soLuongNguoi;
        this.kieuThue = kieuThue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public int getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(int dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public int getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(int chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    public abstract void showInfor();

    @Override
    public String toString() {
        return "\n1. Id: " + getId() +
                "\n2. Tên dịch vụ: " + getTenDichVu() +
                "\n3. Diện tích sử dụng " + getDienTichSuDung() +
                "\n4. Chi phí thuê: " + getChiPhiThue() +
                "\n5. Số lượng người tối đa: " + getSoLuongNguoi() +
                "\n6. Kiểu thuê: " + getKieuThue();
    }
}

