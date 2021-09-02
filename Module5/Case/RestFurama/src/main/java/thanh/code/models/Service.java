package thanh.code.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serviceId;
    @NotBlank
    private String serviceName;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private String serviceStandardRoom;
    private String serviceDescriptionOtherConvenience;
    private double servicePoolArea;
    private int serviceNumberOfFloor;
    private String urlImage;

    @ManyToOne(targetEntity = ServiceType.class)
    @Resource
    @JsonManagedReference(value = "serviceType")
    private ServiceType serviceType;

    @ManyToOne(targetEntity = RentType.class)
    @Resource
    @JsonManagedReference(value = "rentType")
    private RentType rentType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference(value = "contract")
    private Set<Contract> contract;

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
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

    public String getServiceStandardRoom() {
        return serviceStandardRoom;
    }

    public void setServiceStandardRoom(String serviceStandardRoom) {
        this.serviceStandardRoom = serviceStandardRoom;
    }

    public String getServiceDescriptionOtherConvenience() {
        return serviceDescriptionOtherConvenience;
    }

    public void setServiceDescriptionOtherConvenience(String serviceDescriptionOtherConvenience) {
        this.serviceDescriptionOtherConvenience = serviceDescriptionOtherConvenience;
    }

    public double getServicePoolArea() {
        return servicePoolArea;
    }

    public void setServicePoolArea(double servicePoolArea) {
        this.servicePoolArea = servicePoolArea;
    }

    public int getServiceNumberOfFloor() {
        return serviceNumberOfFloor;
    }

    public void setServiceNumberOfFloor(int serviceNumberOfFloor) {
        this.serviceNumberOfFloor = serviceNumberOfFloor;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Service() {
    }
}
