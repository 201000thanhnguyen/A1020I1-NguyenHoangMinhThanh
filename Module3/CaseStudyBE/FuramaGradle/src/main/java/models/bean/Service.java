package models.bean;

public class Service {
    private int serviceId;
    private String serviceName;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private int rentTypeId;
    private String rentTypeName;
    private double rentTypeCost;
    private int serviceTypeId;
    private String serviceTypeName;
    private String standardRoom;
    private String descOtherConvenience;
    private double poolArea;
    private int numberOfFloors;

    public Service() {
    }

    public Service(int serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople,
                   int rentTypeId, String rentTypeName, double rentTypeCost, int serviceTypeId, String serviceTypeName,
                   String standardRoom, String descOtherConvenience, double poolArea, int numberOfFloors) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.standardRoom = standardRoom;
        this.descOtherConvenience = descOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Service(String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, int rentTypeId,
                   int serviceTypeId, String standardRoom, String descOtherConvenience, double poolArea,
                   int numberOfFloors) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descOtherConvenience = descOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescOtherConvenience() {
        return descOtherConvenience;
    }

    public void setDescOtherConvenience(String descOtherConvenience) {
        this.descOtherConvenience = descOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
