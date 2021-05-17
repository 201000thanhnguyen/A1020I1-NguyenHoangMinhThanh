package models.service;

import models.bean.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer> {

    @Override
    List<Customer> listInService();

    @Override
    String addInService(Customer customer);

    @Override
    String deleteInService(int id);

    @Override
    String editInService(Customer customer);

    @Override
    Customer detailInService(int id);

    @Override
    List<Customer> findInService(String byName);
}
