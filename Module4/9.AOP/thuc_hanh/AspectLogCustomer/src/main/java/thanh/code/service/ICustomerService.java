package thanh.code.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thanh.code.models.Customer;
import thanh.code.models.Province;

public interface ICustomerService {
    Page<Customer> findAllPage(Pageable pageable);

    Iterable<Customer> findAll();

    Iterable<Customer> findAllByProvince(Province province);

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    void update(Customer customer);

    Page<Customer> search(String valueSearch, Pageable pageable);
}
