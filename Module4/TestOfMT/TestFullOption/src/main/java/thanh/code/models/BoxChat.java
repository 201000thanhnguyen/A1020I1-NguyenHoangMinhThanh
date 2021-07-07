package thanh.code.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class BoxChat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boxChatId;
    private String boxChatName;

    @OneToMany(mappedBy = "boxChat", cascade = CascadeType.ALL)
    private List<People> peopleList;

    public BoxChat() {
    }

    public BoxChat(int boxChatId, String boxChatName, List<People> peopleList) {
        this.boxChatId = boxChatId;
        this.boxChatName = boxChatName;
        this.peopleList = peopleList;
    }

    public int getBoxChatId() {
        return boxChatId;
    }

    public void setBoxChatId(int boxChatId) {
        this.boxChatId = boxChatId;
    }

    public String getBoxChatName() {
        return boxChatName;
    }

    public void setBoxChatName(String boxChatName) {
        this.boxChatName = boxChatName;
    }
}
