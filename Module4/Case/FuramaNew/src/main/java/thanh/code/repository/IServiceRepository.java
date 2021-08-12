package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.Service;

public interface IServiceRepository extends JpaRepository<Service, Integer> {
}
