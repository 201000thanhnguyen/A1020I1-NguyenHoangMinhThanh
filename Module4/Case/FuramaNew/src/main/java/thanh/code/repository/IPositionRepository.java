package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.Position;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
