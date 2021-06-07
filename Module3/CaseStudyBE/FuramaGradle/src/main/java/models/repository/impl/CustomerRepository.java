package models.repository.impl;

import models.bean.Customer;
import models.repository.ConnectRepository;
import models.repository.ICustomerRepository;

import java.sql.*;
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
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String addInRepository(Customer customer) {
        String msg = null;
        try {
            PreparedStatement preparedStatement =
                    this.connectRepository.getConnection().prepareStatement(
                            "insert into Customer values (null , ?, ?, ?, ?, ?, ?, ?, ?)"
                    );
            setDataPreparedStatement(customer, preparedStatement);

            int result = preparedStatement.executeUpdate();
            msg = result > 0 ? "Add Success" : "Add Fail";
        } catch (SQLException ex){
            ex.printStackTrace();
            msg = ex.toString();
        } catch (Exception e){
            e.printStackTrace();
            msg += " | " + e.toString();
        }
        return msg;
    }

    @Override
    public int countInRepository() {
        int countCustomer = 0;
        try {
            CallableStatement callableStatement =
                    this.connectRepository.getConnection().prepareCall(
                      "call sp_count_customer"
                    );
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                countCustomer += resultSet.getInt("numberCustomer");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return countCustomer;
    }

    @Override
    public List<Customer> listLimitInRepository(int index, int getNumber) {
        List<Customer> customerList = new ArrayList<>();
        try {
            CallableStatement callableStatement =
                    this.connectRepository.getConnection().prepareCall(
                            "call sp_limit_customer(?,?)"
                    );
            callableStatement.setInt(1,index);
            callableStatement.setInt(2,getNumber);
            return getListCustomer(customerList, callableStatement);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteInRepository(int id) {
        String msg = null;
        try {
            
            PreparedStatement preparedStatement =
                    this.connectRepository.getConnection().prepareStatement(
                      "delete from Customer where customerId = ?"
                    );
            preparedStatement.setInt(1,id);
            int result = preparedStatement.executeUpdate();
            msg = result != 0 ? "Delete Success" : "Delete Fail";
        }catch (SQLException ex){
            msg = ex.toString();
        }catch (Exception e){
            msg += e.toString();
        }
        return msg;
    }

    @Override
    public String editInRepository(Customer customer) {
        String msg = null;
        try {
            PreparedStatement preparedStatement =
                    this.connectRepository.getConnection().prepareStatement(
                      "update Customer set customerTypeId = ?, customerName = ?, customerBirthday = ?, customerGender = ?, customerIdCard = ?, customerPhone = ?, customerEmail = ?, customerAddress = ? where customerId = ?"
                    );
            setDataPreparedStatement(customer, preparedStatement);
            preparedStatement.setInt(9,customer.getCustomerId());

            int result = preparedStatement.executeUpdate();
            return msg = result > 0 ? "edit success" : "edit fail";
        }catch (SQLException ex){
            ex.printStackTrace();
            msg = ex.toString();
        }catch (Exception e){
            e.printStackTrace();
            msg += e.toString();
        }
        return msg;
    }


    @Override
    public Customer detailInRepository(int id) {
        try {
            Customer customer = new Customer();
            PreparedStatement preparedStatement =
                    this.connectRepository.getConnection().prepareStatement(
                      "select cu.*, cuT.customerTypeName from Customer cu inner join CustomerType cuT on cu.customerTypeId = cuT.customerTypeId where customerId = ?"
                    );
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer.setCustomerId(resultSet.getInt("customerId"));
                customer.setCustomerTypeId(resultSet.getInt("customerTypeId"));
                customer.setCustomerTypeName(resultSet.getString("customerTypeName"));
                customer.setCustomerName(resultSet.getString("customerName"));
                customer.setCustomerBirthday(resultSet.getString("customerBirthday"));
                customer.setCustomerGender(resultSet.getInt("customerGender"));
                customer.setCustomerIdCard(resultSet.getString("customerIdCard"));
                customer.setCustomerPhone(resultSet.getString("customerPhone"));
                customer.setCustomerEmail(resultSet.getString("customerEmail"));
                customer.setCustomerAddress(resultSet.getString("customerAddress"));
            }
            return customer;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findInRepository(String byName) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.connectRepository.getConnection().prepareStatement(
                            "select cu.*, cuT.customerTypeName from Customer cu inner join CustomerType cuT on cu.customerTypeId = cuT.customerTypeId where customerName like ?"
                    );
            preparedStatement.setString(1, "%" + byName + "%");
            return getListCustomer(customerList, preparedStatement);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private List<Customer> getListCustomer(List<Customer> customerList, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        Customer customer = null;
        while (resultSet.next()){
            customer = new Customer(
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
    }

    private void setDataPreparedStatement(Customer customer, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1,customer.getCustomerTypeId());
        preparedStatement.setString(2,customer.getCustomerName());
        preparedStatement.setString(3,customer.getCustomerBirthday());
        preparedStatement.setInt(4,customer.getCustomerGender());
        preparedStatement.setString(5,customer.getCustomerIdCard());
        preparedStatement.setString(6,customer.getCustomerPhone());
        preparedStatement.setString(7,customer.getCustomerEmail());
        preparedStatement.setString(8,customer.getCustomerAddress());
    }
}
