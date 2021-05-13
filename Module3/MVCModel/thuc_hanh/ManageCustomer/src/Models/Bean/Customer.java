package Models.Bean;

public class Customer {
    private String idCustomer;
    private String nameCustomer;
    private int ageCustomer;
    private int genderCustomer;
    private String avatarCustomer;

    public Customer() {
    }

    public Customer(String idCustomer, String nameCustomer, int ageCustomer, int genderCustomer, String avatarCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.ageCustomer = ageCustomer;
        this.genderCustomer = genderCustomer;
        this.avatarCustomer = avatarCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public int getAgeCustomer() {
        return ageCustomer;
    }

    public void setAgeCustomer(int ageCustomer) {
        this.ageCustomer = ageCustomer;
    }

    public int getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(int genderCustomer) {
        this.genderCustomer = genderCustomer;
    }


    public String getAvatarCustomer() {
        return avatarCustomer;
    }

    public void setAvatarCustomer(String avatarCustomer) {
        this.avatarCustomer = avatarCustomer;
    }
}
