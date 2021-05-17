package models.repository.impl;

import models.bean.CustomerType;
import models.repository.ConnectRepository;
import models.repository.ICustomerTypeRepository;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    ConnectRepository connectRepository = new ConnectRepository();

    @Override
    public List<CustomerType> listInRepository() {
        List<CustomerType> list = new ArrayList<>();
        try {
            Statement statement = this.connectRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from CustomerType");
            while (resultSet.next()){
                CustomerType customerType = new CustomerType();
                customerType.setCustomerTypeId(resultSet.getInt("customerTypeId"));
                customerType.setCustomerTypeName(resultSet.getString("customerTypeName"));

                list.add(customerType);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String addInRepository(CustomerType customerType) {
        return null;
    }

    @Override
    public String deleteInRepository(int id) {
        return null;
    }

    @Override
    public String editInRepository(CustomerType customerType) {
        return null;
    }

    @Override
    public CustomerType detailInRepository(int id) {
        return null;
    }

    @Override
    public List<CustomerType> findInRepository(String byName) {
        return null;
    }
}
