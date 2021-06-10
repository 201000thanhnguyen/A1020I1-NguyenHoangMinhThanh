package top.minhthanh.repository;

import org.springframework.stereotype.Service;
import top.minhthanh.models.Customer;

import java.util.List;

public interface ICustomerRepository {

    public List<Customer> listCustomer();

    public void editCustomer(Customer customer);
}
