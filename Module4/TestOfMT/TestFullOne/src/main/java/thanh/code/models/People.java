package thanh.code.models;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int peopleId;
    @NotNull
    @NotEmpty
    @NotBlank
    private String peopleName;
    private Date peopleBirthday;
    private String peopleDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "accountId")
    private Account account;

    public People() {
    }


    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public Date getPeopleBirthday() {
        return peopleBirthday;
    }

    public void setPeopleBirthday(Date peopleBirthday) {
        this.peopleBirthday = peopleBirthday;
    }

    public String getPeopleDescription() {
        return peopleDescription;
    }

    public void setPeopleDescription(String peopleDescription) {
        this.peopleDescription = peopleDescription;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
