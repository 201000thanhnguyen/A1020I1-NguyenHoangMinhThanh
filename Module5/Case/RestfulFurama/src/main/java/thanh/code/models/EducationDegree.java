package thanh.code.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int educationDegreeId;
    @NotBlank
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
//    @JsonBackReference(value = "employee")
    private Set<Employee> employee;

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public EducationDegree() {
    }
}
