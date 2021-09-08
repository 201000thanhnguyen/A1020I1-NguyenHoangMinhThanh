package thanh.code.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Entity
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contractId;
    private String contractStartDate;
    private String contractEndDate;
    private double contractDeposit;
    private double contractTotalMoney;

    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    @ManyToOne(targetEntity = Service.class)
    private Service service;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetail;

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Contract() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        LocalDateTime localDateTimeCurrent = LocalDateTime.now();
        if (!contract.getContractStartDate().isEmpty() && !contract.getContractEndDate().isEmpty()) {

            LocalDateTime localDateTimeStart = LocalDateTime.parse(contract.getContractStartDate());
            LocalDateTime localDateTimeEnd = LocalDateTime.parse(contract.getContractEndDate());

            // check contract date with current date
            if (localDateTimeStart.getYear() > localDateTimeCurrent.getYear()) {
                errors.rejectValue("contractStartDate", "contract.greaterThanCurrentYear");
            } else {
                if (localDateTimeStart.getDayOfYear() > localDateTimeCurrent.getDayOfYear()) {
                    errors.rejectValue("contractStartDate", "contract.greaterThanCurrentDate");
                }

                // check contract date with contract end date
                // 1.contract termination date before the contract date
                if (localDateTimeStart.getDayOfYear() > localDateTimeEnd.getDayOfYear()) {
                    errors.rejectValue("contractEndDate", "contract.invalidTwoDay");
                }
                if (localDateTimeEnd.getDayOfYear() < localDateTimeStart.getDayOfYear()) {
                    errors.rejectValue("contractStartDate", "contract.invalidTwoDay");
                }

                // end in 1 day
                if (localDateTimeStart.getDayOfYear() == localDateTimeEnd.getDayOfYear()) {
                    System.out.println(localDateTimeStart.getHour());
                    System.out.println(localDateTimeEnd.getHour());
                    if (localDateTimeStart.getHour() > localDateTimeEnd.getHour()) {
                        errors.rejectValue("contractStartDate", "contract.invalidTwoTime");
                        errors.rejectValue("contractEndDate", "contract.invalidTwoTime");
                    }
                }
            }
        } else {
            errors.rejectValue("contractStartDate", "contract.blank");
            errors.rejectValue("contractEndDate", "contract.blank");
        }
    }
}
