package models.repository;

import models.bean.Employee;

import java.util.List;

public interface IEmployeeRepository extends IRepository<Employee> {
    @Override
    List<Employee> listInRepository();

    @Override
    String addInRepository(Employee employee);

    @Override
    String deleteInRepository(int id);

    @Override
    String editInRepository(Employee employee);

    @Override
    Employee detailInRepository(int id);

    @Override
    List<Employee> findInRepository(String byName);

    @Override
    int countInRepository();

    @Override
    List<Employee> listLimitInRepository(int index, int getNumber);
}
