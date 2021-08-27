package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.CustomerType;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
