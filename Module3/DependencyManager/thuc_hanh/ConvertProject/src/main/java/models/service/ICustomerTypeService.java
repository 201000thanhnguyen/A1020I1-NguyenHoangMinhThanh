package models.service;

import models.bean.CustomerType;

import java.util.List;

public interface ICustomerTypeService extends IService<CustomerType> {
    @Override
    List<CustomerType> listInService();

    @Override
    String addInService(CustomerType customerType);

    @Override
    String deleteInService(int id);

    @Override
    String editInService(CustomerType customerType);

    @Override
    CustomerType detailInService(int id);

    @Override
    List<CustomerType> findInService(String byName);

    @Override
    int countInService();

    @Override
    List<CustomerType> listLimitInService(int index, int getNumber);
}
