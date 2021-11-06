package thanh.code.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class User {
    @Id
    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
//    @JsonBackReference(value = "employee")
    private Employee employee;

    public User() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
