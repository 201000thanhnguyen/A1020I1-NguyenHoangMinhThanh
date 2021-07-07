package thanh.code.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int peopleId;
    private String peopleName;
    private Date peopleBirthday;

    @ManyToOne(targetEntity = BoxChat.class)
    private BoxChat boxChat;

    public People() {
    }

    public People(int peopleId, String peopleName, Date peopleBirthday) {
        this.peopleId = peopleId;
        this.peopleName = peopleName;
        this.peopleBirthday = peopleBirthday;
    }

    public People(String peopleName, Date peopleBirthday) {
        this.peopleName = peopleName;
        this.peopleBirthday = peopleBirthday;
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

    public BoxChat getBoxChat() {
        return boxChat;
    }

    public void setBoxChat(BoxChat boxChat) {
        this.boxChat = boxChat;
    }
}
