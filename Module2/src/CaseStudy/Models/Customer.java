package CaseStudy.Models;

public class Customer extends Services {
    private String nameCus;
    private String birthdayCus;
    private String genderCus;
    private String idCardCus;
    private String phoneCus;
    private String emailCus;
    private String typeCus;
    private String addressCus;

    public Customer() {
    }

    public Customer(String nameCus, String birthdayCus, String genderCus, String idCardCus, String phoneCus, String emailCus, String typeCus, String addressCus) {
        this.nameCus = nameCus;
        this.birthdayCus = birthdayCus;
        this.genderCus = genderCus;
        this.idCardCus = idCardCus;
        this.phoneCus = phoneCus;
        this.emailCus = emailCus;
        this.typeCus = typeCus;
        this.addressCus = addressCus;
    }

    public Customer(String nameCus, String birthdayCus, String genderCus, String idCardCus, String phoneCus, String emailCus, String typeCus, String addressCus, String id, String tenDichVu, int dienTichSuDung, int chiPhiThue, int soLuongNguoi, String kieuThue) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.nameCus = nameCus;
        this.birthdayCus = birthdayCus;
        this.genderCus = genderCus;
        this.idCardCus = idCardCus;
        this.phoneCus = phoneCus;
        this.emailCus = emailCus;
        this.typeCus = typeCus;
        this.addressCus = addressCus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getBirthdayCus() {
        return birthdayCus;
    }

    public void setBirthdayCus(String birthdayCus) {
        this.birthdayCus = birthdayCus;
    }

    public String getGenderCus() {
        return genderCus;
    }

    public void setGenderCus(String genderCus) {
        this.genderCus = genderCus;
    }

    public String getIdCardCus() {
        return idCardCus;
    }

    public void setIdCardCus(String idCardCus) {
        this.idCardCus = idCardCus;
    }

    public String getPhoneCus() {
        return phoneCus;
    }

    public void setPhoneCus(String phoneCus) {
        this.phoneCus = phoneCus;
    }

    public String getEmailCus() {
        return emailCus;
    }

    public void setEmailCus(String emailCus) {
        this.emailCus = emailCus;
    }

    public String getTypeCus() {
        return typeCus;
    }

    public void setTypeCus(String typeCus) {
        this.typeCus = typeCus;
    }

    public String getAddressCus() {
        return addressCus;
    }

    public void setAddressCus(String addressCus) {
        this.addressCus = addressCus;
    }

    @Override
    public void showInfor(){
        System.out.println(
                "\n\tHọ tên Customer: " + getNameCus() +
                "\n\tNgày sinh: " + getBirthdayCus() +
                "\n\tGiới tính: " + getGenderCus() +
                "\n\tSố cmnd: " + getIdCardCus() +
                "\n\tSố điện thoại: " + getPhoneCus() +
                "\n\temail: " + getEmailCus() +
                "\n\tloại khách: " + getTypeCus() +
                "\nĐịa chỉ: " + getAddressCus());
//                "\nId dịch vụ: " + getId() +
//                "\nTên dịch vụ: " + getTenDichVu() +
//                "\nDiện tích sử dụng: " + getDienTichSuDung() +
//                "\nChi phí thuê: " + getChiPhiThue() +
//                "\nSố lượng người: " + getSoLuongNguoi() +
//                "\nKiểu thuê: " + getKieuThue());
    }

    @Override
    public String toString() {
        return "\n\tHọ tên Customer: " + getNameCus() +
                "\n\tNgày sinh: " + getBirthdayCus() +
                "\n\tGiới tính: " + getGenderCus() +
                "\n\tSố cmnd: " + getIdCardCus() +
                "\n\tSố điện thoại: " + getPhoneCus() +
                "\n\temail: " + getEmailCus() +
                "\n\tloại khách: " + getTypeCus() +
                "\n\tĐịa chỉ: " + getAddressCus();
    }
}
