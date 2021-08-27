package thanh.code.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import thanh.code.models.Employee;
import thanh.code.repository.IEmployeeRepository;
import thanh.code.service.IEmployeeService;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> listEntity() {
        return this.employeeRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void removeEntity(Employee employee) {
        this.employeeRepository.delete(employee);
    }

    @Override
    public Employee findByIdInt(int id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> listLimitEntity(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public Iterable<Employee> employeeIterable() {
        return this.employeeRepository.findAll();
    }
}
