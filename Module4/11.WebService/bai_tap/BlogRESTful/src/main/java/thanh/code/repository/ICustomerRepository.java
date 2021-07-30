package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
