package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.Customer;
import thanh.code.repository.ICustomerRepository;
import thanh.code.service.ICustomerService;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    final ICustomerRepository _customerRepository;

    public CustomerService(ICustomerRepository customerRepository){
        _customerRepository = customerRepository;
    }

    @Override
    public List<Customer> listEntity() {
        return this._customerRepository.listEntity();
    }

    @Override
    public String addEntity(Customer customer) {
        return this._customerRepository.addEntity(customer);
    }

    @Override
    public Customer findEntity(int id) {
        return this._customerRepository.findEntity(id);
    }
}
