package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thanh.code.models.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
