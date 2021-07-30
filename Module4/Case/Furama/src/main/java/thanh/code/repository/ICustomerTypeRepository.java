package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.CustomerType;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
