package models.service.impl;

import models.bean.Employee;
import models.repository.IEmployeeRepository;
import models.repository.impl.EmployeeRepository;
import models.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> listInService() {
        return this.employeeRepository.listInRepository();
    }

    @Override
    public String addInService(Employee employee) {
        return this.employeeRepository.addInRepository(employee);
    }

    @Override
    public String deleteInService(int id) {
        return this.employeeRepository.deleteInRepository(id);
    }

    @Override
    public String editInService(Employee employee) {
        return this.employeeRepository.editInRepository(employee);
    }

    @Override
    public Employee detailInService(int id) {
        return this.employeeRepository.detailInRepository(id);
    }

    @Override
    public List<Employee> findInService(String byName) {
        return this.employeeRepository.findInRepository(byName);
    }

    @Override
    public int countInService() {
        return this.employeeRepository.countInRepository();
    }

    @Override
    public List<Employee> listLimitInService(int index, int getNumber) {
        return this.employeeRepository.listLimitInRepository(index, getNumber);
    }
}
