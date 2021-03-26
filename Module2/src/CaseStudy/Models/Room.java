package CaseStudy.Models;

public class Room extends Services {
    private String dichVuMienPhiDiKem;

    public Room() {
    }

    public Room(String id, String tenDichVu, int dienTichSuDung, int chiPhiThue, int soLuongNguoi, String kieuThue, String dichVuMienPhiDiKem) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public String getDichVuMienPhiDiKem() {
        return dichVuMienPhiDiKem;
    }

    public void setDichVuMienPhiDiKem(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    @Override
    public void showInfor(){
        System.out.println(
                "\nId: " + getId() +
                "\nTên dịch vụ: " + getTenDichVu() +
                "\nDiện tích sử dụng " + getDienTichSuDung() +
                "\nChi phí thuê: " + getChiPhiThue() +
                "\nSố lượng người tối đa: " + getSoLuongNguoi() +
                "\nKiểu thuê: " + getKieuThue() +
                "\nDịch vụ miễn phí đi kèm: " + getDichVuMienPhiDiKem());
    }

    @Override
    public String toString() {
        return "\n\tId: " + getId() +
                "\n\tTên dịch vụ: " + getTenDichVu() +
                "\n\tDiện tích sử dụng " + getDienTichSuDung() +
                "\n\tChi phí thuê: " + getChiPhiThue() +
                "\n\tSố lượng người tối đa: " + getSoLuongNguoi() +
                "\n\tKiểu thuê: " + getKieuThue() +
                "\n\tDịch vụ miễn phí đi kèm: " + getDichVuMienPhiDiKem();
    }
}
