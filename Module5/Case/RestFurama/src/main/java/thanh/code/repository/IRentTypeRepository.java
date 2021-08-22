package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.RentType;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
