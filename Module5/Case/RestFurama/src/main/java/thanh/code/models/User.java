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

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonManagedReference(value = "role")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "roleId")
    private Set<Role> role;

    @OneToOne(mappedBy = "user")
    @JsonBackReference(value = "employee")
    private Employee employee;

    public User() {
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
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
