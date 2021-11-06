package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.CustomerType;
import thanh.code.repository.ICustomerTypeRepository;
import thanh.code.service.ICustomerTypeService;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    final ICustomerTypeRepository customerTypeRepository;

    public CustomerTypeService(ICustomerTypeRepository customerTypeRepository) {
        this.customerTypeRepository = customerTypeRepository;
    }

    @Override
    public Iterable<CustomerType> customerTypeIterable() {
        return this.customerTypeRepository.findAll();
    }

    @Override
    public List<CustomerType> listEntity() {
        return this.customerTypeRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(CustomerType customerType) {
        this.customerTypeRepository.save(customerType);
    }

    @Override
    public void removeEntity(CustomerType customerType) {
        this.customerTypeRepository.delete(customerType);
    }

    @Override
    public CustomerType findByIdInt(int id) {
        return this.customerTypeRepository.findById(id).orElse(null);
    }
}
