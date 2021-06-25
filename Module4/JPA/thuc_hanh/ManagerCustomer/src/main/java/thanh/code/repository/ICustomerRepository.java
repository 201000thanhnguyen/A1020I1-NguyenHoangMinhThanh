package thanh.code.repository;

import org.springframework.stereotype.Repository;
import thanh.code.models.Customer;

import java.util.List;


public interface ICustomerRepository extends IRepository<Customer> {
    List<Customer> listEntity();
}
