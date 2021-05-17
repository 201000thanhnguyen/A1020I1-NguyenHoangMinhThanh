package models.repository.impl;

import models.bean.Customer;
import models.repository.ConnectRepository;
import models.repository.ICustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    ConnectRepository connectRepository = new ConnectRepository();

    @Override
    public List<Customer> listInRepository() {
        List<Customer> customerList = new ArrayList<>();
        try {
            Statement statement = this.connectRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery
                    ("select cu.*, cuT.customerTypeName from Customer cu inner join CustomerType cuT on cu.customerTypeId = cuT.customerTypeId");
            while (resultSet.next()){
                Customer customer = new Customer(
                        resultSet.getInt("customerId"),
                        resultSet.getInt("customerTypeId"),
                        resultSet.getString("customerTypeName"),
                        resultSet.getString("customerName"),
                        resultSet.getString("customerBirthday"),
                        resultSet.getInt("customerGender"),
                        resultSet.getString("customerIdCard"),
                        resultSet.getString("customerPhone"),
                        resultSet.getString("customerEmail"),
                        resultSet.getString("customerAddress")
                );
                customerList.add(customer);
            }
            return customerList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String addInRepository(Customer customer) {
        try {
            PreparedStatement preparedStatement =
                    this.connectRepository.getConnection().prepareStatement(
                            "insert into Customer"
                    );

            return "add success";
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    public String deleteInRepository(int id) {
        return null;
    }

    @Override
    public String editInRepository(Customer customer) {
        return null;
    }

    @Override
    public Customer detailInRepository(int id) {
        return null;
    }

    @Override
    public List<Customer> findInRepository(String byName) {
        return null;
    }
}
