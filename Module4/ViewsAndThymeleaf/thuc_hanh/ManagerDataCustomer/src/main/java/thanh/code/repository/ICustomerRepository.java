package thanh.code.repository;

import thanh.code.models.Customer;

import java.util.List;

public interface ICustomerRepository extends IRepository<Customer> {
    @Override
    List<Customer> listEntity();

    @Override
    String addEntity(Customer customer);

    @Override
    Customer findEntity(int id);
}
