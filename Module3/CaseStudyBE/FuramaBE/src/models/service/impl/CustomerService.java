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
        return this.customerRepository.addInRepository(customer);
    }

    @Override
    public int countInService() {
        return this.customerRepository.countInRepository();
    }

    @Override
    public List<Customer> listLimitInService(int index, int getNumber) {
        return this.customerRepository.listLimitInRepository(index, getNumber);
    }

    @Override
    public String deleteInService(int id) {
        return this.customerRepository.deleteInRepository(id);
    }

    @Override
    public String editInService(Customer customer) {
        return null;
    }

    @Override
    public Customer detailInService(int id) {
        return this.customerRepository.detailInRepository(id);
    }

    @Override
    public List<Customer> findInService(String byName) {
        return null;
    }
}
