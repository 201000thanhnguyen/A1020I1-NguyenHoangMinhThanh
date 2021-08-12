package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.EducationDegree;

public interface IEducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
