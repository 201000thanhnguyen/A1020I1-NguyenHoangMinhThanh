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
    public List<Customer> listCustomer() {
        return this._customerRepository.findAll();
    }

    @Override
    public void addCustomer(Customer customer) {
         this._customerRepository.save(customer);
    }

    @Override
    public Customer detailCustomer(int id) {
        return this._customerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCustomer(int id) {
        this._customerRepository.deleteById(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        this._customerRepository.save(customer);
    }
}
