package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.RentType;

public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
