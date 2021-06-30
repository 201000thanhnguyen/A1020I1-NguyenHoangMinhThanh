package thanh.code.models;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Customer {
    private int customerId;
    private String customerName;
    private String[] customerLanguage;
    private Date customerBirthday;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String[] customerLanguage, Date customerBirthday) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerLanguage = customerLanguage;
        this.customerBirthday = customerBirthday;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String[] getCustomerLanguage() {
        return customerLanguage;
    }

    public void setCustomerLanguage(String[] customerLanguage) {
        this.customerLanguage = customerLanguage;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }
}
