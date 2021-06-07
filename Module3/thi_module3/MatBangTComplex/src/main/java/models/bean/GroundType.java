package models.bean;

public class GroundType {
    private int groundTypeId;
    private String groundTypeName;

    public GroundType() {
    }

    public GroundType(int groundTypeId, String groundTypeName) {
        this.groundTypeId = groundTypeId;
        this.groundTypeName = groundTypeName;
    }

    public int getGroundTypeId() {
        return groundTypeId;
    }

    public void setGroundTypeId(int groundTypeId) {
        this.groundTypeId = groundTypeId;
    }

    public String getGroundTypeName() {
        return groundTypeName;
    }

    public void setGroundTypeName(String groundTypeName) {
        this.groundTypeName = groundTypeName;
    }
}
