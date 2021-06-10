package top.minhthanh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.minhthanh.models.Customer;
import top.minhthanh.repository.ICustomerRepository;
import top.minhthanh.repository.impl.CustomerRepository;
import top.minhthanh.service.ICustomerService;

import java.util.List;

@Component
public class CustomerService implements ICustomerService {
    final
    ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
//    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> listCustomer() {
        return this.customerRepository.listCustomer();
    }

    @Override
    public void editCustomer(Customer customer) {

    }
}
