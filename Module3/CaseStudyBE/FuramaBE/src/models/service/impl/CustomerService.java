package models.service.impl;

import models.bean.Customer;
import models.repository.ICustomerRepository;
import models.repository.impl.CustomerRepository;
import models.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> listInService() {
        return this.customerRepository.listInRepository();
    }

    @Override
    public String addInService(Customer customer) {
        return null;
    }

    @Override
    public String deleteInService(int id) {
        return null;
    }

    @Override
    public String editInService(Customer customer) {
        return null;
    }

    @Override
    public Customer detailInService(int id) {
        return null;
    }

    @Override
    public List<Customer> findInService(String byName) {
        return null;
    }
}
