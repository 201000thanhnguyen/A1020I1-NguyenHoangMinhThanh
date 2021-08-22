package thanh.code.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thanh.code.models.Customer;

public interface ICustomerService extends ICRUDService<Customer> {
    Page<Customer> listLimitEntity(Pageable pageable);

    Iterable<Customer> customerIterable();
}
