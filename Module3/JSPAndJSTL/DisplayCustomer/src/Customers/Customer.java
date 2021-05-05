package Customers;

public class Customer {
    private String name;
    private String dateOfBirth;
    private String address;
    private String urlAvatar;

    public Customer() {
    }

    public Customer(String name, String dateOfBirth, String address, String urlImg) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.urlAvatar = urlImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }
}