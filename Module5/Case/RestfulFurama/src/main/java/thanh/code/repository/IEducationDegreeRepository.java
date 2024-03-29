package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.EducationDegree;

@Repository
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
