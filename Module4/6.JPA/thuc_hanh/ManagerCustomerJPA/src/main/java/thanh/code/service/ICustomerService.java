package thanh.code.service;

import thanh.code.models.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> listCustomer();

    void addCustomer(Customer customer);

    Customer detailCustomer(int id);

    void deleteCustomer(int id);

    void editCustomer(Customer customer);
}
