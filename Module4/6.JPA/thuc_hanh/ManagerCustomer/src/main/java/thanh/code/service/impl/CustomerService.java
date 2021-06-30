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
        return this._customerRepository.listEntity();
    }

    @Override
    public String addCustomer(Customer customer) {
        return this._customerRepository.addEntity(customer);
    }

    @Override
    public Customer detailCustomer(int id) {
        return this._customerRepository.detailEntity(id);
    }

    @Override
    public String deleteCustomer(int id) {
        return this._customerRepository.deleteEntity(id);
    }

    @Override
    public String editCustomer(Customer customer) {
        return this._customerRepository.editEntity(customer);
    }
}
