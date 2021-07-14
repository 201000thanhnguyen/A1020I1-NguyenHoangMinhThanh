package thanh.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thanh.code.models.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
