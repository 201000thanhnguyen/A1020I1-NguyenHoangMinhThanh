package models.bean;

public class GroundStatus {

    private int groundStatusId;
    private String groundStatusName;

    public GroundStatus() {
    }

    public GroundStatus(int groundStatusId, String groundStatusName) {
        this.groundStatusId = groundStatusId;
        this.groundStatusName = groundStatusName;
    }

    public int getGroundStatusId() {
        return groundStatusId;
    }

    public void setGroundStatusId(int groundStatusId) {
        this.groundStatusId = groundStatusId;
    }

    public String getGroundStatusName() {
        return groundStatusName;
    }

    public void setGroundStatusName(String groundStatusName) {
        this.groundStatusName = groundStatusName;
    }
}
