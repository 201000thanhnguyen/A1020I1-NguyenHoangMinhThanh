package thanh.code.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thanh.code.models.Employee;

public interface IEmployeeService extends ICRUDService<Employee> {
    Page<Employee> listLimitEntity(Pageable pageable);
}
