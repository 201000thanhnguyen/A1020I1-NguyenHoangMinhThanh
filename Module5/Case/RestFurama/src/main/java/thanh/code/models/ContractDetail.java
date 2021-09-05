package thanh.code.models;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Resource;
import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contractDetailId;
    private int contractDetailQuantity;

    @ManyToOne(targetEntity = AttachService.class, cascade = CascadeType.PERSIST)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "attachServiceId", scope = Integer.class)
//    @JsonManagedReference(value = "attachService")
    private AttachService attachService;

    @ManyToOne(targetEntity = Contract.class, cascade = CascadeType.PERSIST)
//    @JsonManagedReference(value = "contract")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "contractId", scope = Integer.class)
    private Contract contract;

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getContractDetailQuantity() {
        return contractDetailQuantity;
    }

    public void setContractDetailQuantity(int contractDetailQuantity) {
        this.contractDetailQuantity = contractDetailQuantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ContractDetail() {
    }
}
