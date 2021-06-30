package top.minhthanh.repository.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import top.minhthanh.models.Customer;
import top.minhthanh.repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1,"cus 1","cus1@gmail.com","địa chỉ cus 1"));
        customerList.add(new Customer(2,"cus 2","cus2@gmail.com","địa chỉ cus 2"));
        customerList.add(new Customer(3,"cus 3","cus3@gmail.com","địa chỉ cus 3"));
    }

    @Override
    public List<Customer> listCustomer() {
        return customerList;
    }

    @Override
    public void editCustomer(Customer customer) {
        this.listCustomer().get(customer.getId()).setName(customer.getName());
        this.listCustomer().get(customer.getId()).setEmail(customer.getEmail());
        this.listCustomer().get(customer.getId()).setAddress(customer.getAddress());
    }
}
