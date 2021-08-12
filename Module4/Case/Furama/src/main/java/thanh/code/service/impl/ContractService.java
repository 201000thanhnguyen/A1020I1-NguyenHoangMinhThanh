package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.Contract;
import thanh.code.repository.IContractRepository;
import thanh.code.service.IContractService;

import java.util.List;

@Service
public class ContractService implements IContractService {

    private final IContractRepository contractRepository;

    public ContractService(IContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Iterable<Contract> contractIterable() {
        return this.contractRepository.findAll();
    }

    @Override
    public List<Contract> listEntity() {
        return this.contractRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(Contract contract) {
        this.contractRepository.save(contract);
    }

    @Override
    public void removeEntity(Contract contract) {
        this.contractRepository.delete(contract);
    }

    @Override
    public Contract findByIdInt(int id) {
        return this.contractRepository.findById(id).orElse(null);
    }
}
