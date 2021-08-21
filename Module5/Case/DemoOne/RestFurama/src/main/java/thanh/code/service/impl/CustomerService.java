package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.Customer;
import thanh.code.repository.ICustomerRepository;
import thanh.code.service.ICustomerService;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> listEntity() {
        return this.customerRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void removeEntity(Customer customer) {
        this.customerRepository.delete(customer);
    }

    @Override
    public Customer findByIdInt(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }
}
