package thanh.code.repository.impl;

import org.springframework.stereotype.Repository;
import thanh.code.models.Customer;
import thanh.code.repository.ConnectRepository;
import thanh.code.repository.ICustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    final ConnectRepository _connectRepository;

    public CustomerRepository(ConnectRepository connectRepository) {
        _connectRepository = connectRepository;
    }

    @Override
    public List<Customer> listEntity() {
        List<Customer> customerList = new ArrayList<>();
        try {
            Customer customer;
            Statement statement =
                    this._connectRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Customer");
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("customerId"),
                        resultSet.getString("customerName"),
                        resultSet.getString("customerLanguage").split(",".trim()),
                        resultSet.getDate("customerBirthday")
                );
                customerList.add(customer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customerList;
    }

    @Override
    public String addEntity(Customer customer) {
        String msg = null;
        try {
            PreparedStatement preparedStatement =
                    this._connectRepository.getConnection().prepareStatement(
                      "insert into Customer values (null, ?, ?, ?)"
                    );
            String customerLanguage = "";
            for (String item :
                    customer.getCustomerLanguage()) {
                customerLanguage += item;
                customerLanguage += ", ";
            }
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customerLanguage);
            preparedStatement.setDate(3, customer.getCustomerBirthday());
            int result = preparedStatement.executeUpdate();
            msg = result > 0 ? "add success" : "add fail";
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return msg;
    }

    @Override
    public Customer findEntity(int id) {
        Customer customer = new Customer();
        try {
            PreparedStatement preparedStatement =
                    this._connectRepository.getConnection().prepareStatement(
                      "select * from Customer where customerId = ?"
                    );
            preparedStatement.setInt(1, id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                customer.setCustomerId(resultSet.getInt("customerId"));
                customer.setCustomerName(resultSet.getString("customerName"));
                customer.setCustomerLanguage(resultSet.getString("customerLanguage").split(","));
                customer.setCustomerBirthday(resultSet.getDate("customerBirthday"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return customer;
    }
}
