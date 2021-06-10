package top.minhthanh.service;

import top.minhthanh.models.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> listCustomer();

    public void editCustomer(Customer customer);
}
