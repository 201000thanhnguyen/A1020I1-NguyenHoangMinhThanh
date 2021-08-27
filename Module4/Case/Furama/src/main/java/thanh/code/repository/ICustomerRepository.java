package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    
}
