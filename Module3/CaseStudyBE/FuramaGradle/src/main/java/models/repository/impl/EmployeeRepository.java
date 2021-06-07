package models.repository.impl;

import models.bean.Employee;
import models.bean.Employee;
import models.repository.ConnectRepository;
import models.repository.IEmployeeRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    ConnectRepository connectRepository = new ConnectRepository();

    @Override
    public List<Employee> listInRepository() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Statement statement = this.connectRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery
                    ("select emp.*, pos.positionName, edu.educationDegreeName, divi.divisionName from Employee emp inner join Position pos on emp.positionId = pos.positionId inner join EducationDegree edu on emp.educationDegreeId = edu.educationDegreeId inner join Division divi on emp.divisionId = divi.divisionId;");
            while (resultSet.next()){
                Employee employee = new Employee(
                        resultSet.getInt("employeeId"),
                        resultSet.getString("employeeName"),
                        resultSet.getString("employeeBirthday"),
                        resultSet.getString("employeeIdCard"),
                        resultSet.getDouble("employeeSalary"),
                        resultSet.getString("employeePhone"),
                        resultSet.getString("employeeEmail"),
                        resultSet.getString("employeeAddress"),
                        resultSet.getInt("positionId"),
                        resultSet.getString("positionName"),
                        resultSet.getInt("educationDegreeId"),
                        resultSet.getString("educationDegreeName"),
                        resultSet.getInt("divisionId"),
                        resultSet.getString("divisionName"),
                        resultSet.getString("userName")
                );
                employeeList.add(employee);
            }
            return employeeList;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String addInRepository(Employee employee) {
        return null;
    }

    @Override
    public String deleteInRepository(int id) {
        return null;
    }

    @Override
    public String editInRepository(Employee employee) {
        return null;
    }

    @Override
    public Employee detailInRepository(int id) {
        return null;
    }

    @Override
    public List<Employee> findInRepository(String byName) {
        return null;
    }

    @Override
    public int countInRepository() {
        int countEmployee = 0;
        try {
            CallableStatement callableStatement =
                    this.connectRepository.getConnection().prepareCall(
                            "call sp_count_employee"
                    );
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                countEmployee += resultSet.getInt("numberEmployee");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return countEmployee;
    }

    @Override
    public List<Employee> listLimitInRepository(int index, int getNumber) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            CallableStatement callableStatement =
                    this.connectRepository.getConnection().prepareCall(
                            "call sp_limit_employee(?,?)"
                    );
            callableStatement.setInt(1,index);
            callableStatement.setInt(2,getNumber);
            return getListEmployee(employeeList, callableStatement);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private List<Employee> getListEmployee(List<Employee> employeeList, CallableStatement callableStatement) throws SQLException {
        ResultSet resultSet = callableStatement.executeQuery();
        Employee employee = null;
        while (resultSet.next()){
                    employee = new Employee(
                    resultSet.getInt("employeeId"),
                    resultSet.getString("employeeName"),
                    resultSet.getString("employeeBirthday"),
                    resultSet.getString("employeeIdCard"),
                    resultSet.getDouble("employeeSalary"),
                    resultSet.getString("employeePhone"),
                    resultSet.getString("employeeEmail"),
                    resultSet.getString("employeeAddress"),
                    resultSet.getInt("positionId"),
                    resultSet.getString("positionName"),
                    resultSet.getInt("educationDegreeId"),
                    resultSet.getString("educationDegreeName"),
                    resultSet.getInt("divisionId"),
                    resultSet.getString("divisionName"),
                    resultSet.getString("userName")
            );
            employeeList.add(employee);
        }
        return employeeList;
    }
}
