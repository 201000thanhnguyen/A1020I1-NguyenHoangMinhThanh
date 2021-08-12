package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.Division;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
