package thanh.code.repository;

import org.springframework.stereotype.Repository;
import thanh.code.models.Customer;

import java.util.List;


public interface ICustomerRepository extends IRepository<Customer> {

    @Override
    List<Customer> listEntity();

    @Override
    String addEntity(Customer customer);

    @Override
    Customer detailEntity(int id);

    @Override
    String deleteEntity(int id);
}
