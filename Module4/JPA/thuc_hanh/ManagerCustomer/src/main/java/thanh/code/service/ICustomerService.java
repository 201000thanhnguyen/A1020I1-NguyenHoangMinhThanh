package thanh.code.service;

import org.springframework.stereotype.Service;
import thanh.code.models.Customer;
import thanh.code.repository.ICustomerRepository;

import java.util.List;

public interface ICustomerService {

    List<Customer> listCustomer();
}
