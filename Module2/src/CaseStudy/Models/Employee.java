package CaseStudy.Models;

public class Employee {
    private String nameEmp;
    private int ageEmp;
    private String addressEmp;

    public Employee() {
    }

    public Employee(String nameEmp, int ageEmp, String addressEmp) {
        this.nameEmp = nameEmp;
        this.ageEmp = ageEmp;
        this.addressEmp = addressEmp;
    }

    public String getNameEmp() {
        return nameEmp;
    }

    public void setNameEmp(String nameEmp) {
        this.nameEmp = nameEmp;
    }

    public int getAgeEmp() {
        return ageEmp;
    }

    public void setAgeEmp(int ageEmp) {
        this.ageEmp = ageEmp;
    }

    public String getAddressEmp() {
        return addressEmp;
    }

    public void setAddressEmp(String addressEmp) {
        this.addressEmp = addressEmp;
    }

    @Override
    public String toString() {
        return "Tên nhân viên là: " + getNameEmp() + ", " + getAgeEmp() +" tuổi, địa chỉ ở " + getAddressEmp();
    }
}
