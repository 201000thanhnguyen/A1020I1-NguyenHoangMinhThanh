package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.ServiceType;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
