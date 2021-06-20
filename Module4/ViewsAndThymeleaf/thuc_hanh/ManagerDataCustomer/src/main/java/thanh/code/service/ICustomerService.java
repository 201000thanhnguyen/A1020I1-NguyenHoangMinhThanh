package thanh.code.service;

import thanh.code.models.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer> {

    @Override
    List<Customer> listEntity();

    @Override
    String addEntity(Customer customer);

    @Override
    Customer findEntity(int id);
}
