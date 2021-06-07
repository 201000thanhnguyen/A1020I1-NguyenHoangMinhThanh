package models.service;

import models.bean.Employee;

import java.util.List;

public interface IEmployeeService extends IService<Employee> {
    @Override
    List<Employee> listInService();

    @Override
    String addInService(Employee employee);

    @Override
    String deleteInService(int id);

    @Override
    String editInService(Employee employee);

    @Override
    Employee detailInService(int id);

    @Override
    List<Employee> findInService(String byName);

    @Override
    int countInService();

    @Override
    List<Employee> listLimitInService(int index, int getNumber);
}
