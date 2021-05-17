package models.service;

import models.bean.CustomerType;

import java.util.List;

public interface ICustomerTypeService extends IService<CustomerType> {

    List<CustomerType> listInService();
    
    String addInService(CustomerType customerType);

    String deleteInService(int id);

    String editInService(CustomerType customerType);

    CustomerType detailInService(int id);

    List<CustomerType> findInService(String byName);
}
