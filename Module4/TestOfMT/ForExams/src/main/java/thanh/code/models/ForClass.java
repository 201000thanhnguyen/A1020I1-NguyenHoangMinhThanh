package thanh.code.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ForClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int forId;
    private String forName;

    //some note
    //class main is targetEntity
    //sub class is mappedBy and cascade
    //use the suffix to determine whether to use the collection

    public int getForId() {
        return forId;
    }

    public void setForId(int forId) {
        this.forId = forId;
    }

    public String getForName() {
        return forName;
    }

    public void setForName(String forName) {
        this.forName = forName;
    }

    public ForClass() {
    }
}
