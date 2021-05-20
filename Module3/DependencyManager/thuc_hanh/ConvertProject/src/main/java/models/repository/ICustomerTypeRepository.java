package models.repository;

import models.bean.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository extends IRepository<CustomerType> {

    @Override
    List<CustomerType> listInRepository();

    @Override
    String addInRepository(CustomerType customerType);

    @Override
    String deleteInRepository(int id);

    @Override
    String editInRepository(CustomerType customerType);

    @Override
    CustomerType detailInRepository(int id);

    @Override
    List<CustomerType> findInRepository(String byName);

}
