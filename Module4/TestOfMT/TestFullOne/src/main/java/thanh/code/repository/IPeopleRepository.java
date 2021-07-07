package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.People;

public interface IPeopleRepository extends JpaRepository<People, Integer> {

}
