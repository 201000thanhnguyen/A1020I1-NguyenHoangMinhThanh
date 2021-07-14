package thanh.code.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import thanh.code.models.Customer;
import thanh.code.models.Province;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    @Query(value = "SELECT c from CustomerEntity as c WHERE c.name like ?1")
    Page<Customer> search(String valueSearch, Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);
}
