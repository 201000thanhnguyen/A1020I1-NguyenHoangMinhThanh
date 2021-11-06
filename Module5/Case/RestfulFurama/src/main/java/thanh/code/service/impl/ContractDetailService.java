package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.ContractDetail;
import thanh.code.repository.IContractDetailRepository;
import thanh.code.service.IContractDetailService;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    private final IContractDetailRepository contractDetailRepository;

    public ContractDetailService(IContractDetailRepository contractDetailRepository) {
        this.contractDetailRepository = contractDetailRepository;
    }

    @Override
    public List<ContractDetail> listEntity() {
        return this.contractDetailRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }

    @Override
    public void removeEntity(ContractDetail contractDetail) {
        this.contractDetailRepository.delete(contractDetail);
    }

    @Override
    public ContractDetail findByIdInt(int id) {
        return this.contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<ContractDetail> listContractDetailOfOnePeople(int contractId) {
        return this.contractDetailRepository.listContractDetailOfOnePeople(contractId);
    }

    @Override
    public void deleteDetailOneRecord(int contractDetailId, int contractId) {
        this.contractDetailRepository.deleteDetailOneRecord(contractDetailId, contractId);
    }
}
