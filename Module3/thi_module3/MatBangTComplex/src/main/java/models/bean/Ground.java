package models.bean;

public class Ground {
    private String groundId;
    private int groundStatusId;
    private String groundStatusName;
    private double groundAcreage;
    private int groundFloor;
    private int groundTypeId;
    private String groundTypeName;
    private double groundCost;
    private String groundStartDate;
    private  String groundEndDate;

    public Ground() {
    }

    public Ground(String groundId, int groundStatusId, String groundStatusName, double groundAcreage, int groundFloor, int groundTypeId, String groundTypeName, double groundCost, String groundStartDate, String groundEndDate) {
        this.groundId = groundId;
        this.groundStatusId = groundStatusId;
        this.groundStatusName = groundStatusName;
        this.groundAcreage = groundAcreage;
        this.groundFloor = groundFloor;
        this.groundTypeId = groundTypeId;
        this.groundTypeName = groundTypeName;
        this.groundCost = groundCost;
        this.groundStartDate = groundStartDate;
        this.groundEndDate = groundEndDate;
    }

    public String getGroundId() {
        return groundId;
    }

    public void setGroundId(String groundId) {
        this.groundId = groundId;
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

    public double getGroundAcreage() {
        return groundAcreage;
    }

    public void setGroundAcreage(double groundAcreage) {
        this.groundAcreage = groundAcreage;
    }

    public int getGroundFloor() {
        return groundFloor;
    }

    public void setGroundFloor(int groundFloor) {
        this.groundFloor = groundFloor;
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

    public double getGroundCost() {
        return groundCost;
    }

    public void setGroundCost(double groundCost) {
        this.groundCost = groundCost;
    }

    public String getGroundStartDate() {
        return groundStartDate;
    }

    public void setGroundStartDate(String groundStartDate) {
        this.groundStartDate = groundStartDate;
    }

    public String getGroundEndDate() {
        return groundEndDate;
    }

    public void setGroundEndDate(String groundEndDate) {
        this.groundEndDate = groundEndDate;
    }
}
