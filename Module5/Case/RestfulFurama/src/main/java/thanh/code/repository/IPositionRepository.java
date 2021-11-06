package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.Position;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
