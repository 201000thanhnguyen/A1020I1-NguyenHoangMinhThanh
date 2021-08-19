package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.Division;

@Repository
public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
