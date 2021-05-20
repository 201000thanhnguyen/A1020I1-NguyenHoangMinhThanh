package models.repository;

import models.bean.Customer;

import java.util.List;

public interface ICustomerRepository extends IRepository<Customer> {

    @Override
    List<Customer> listInRepository();

    @Override
    String addInRepository(Customer customer);

    @Override
    String deleteInRepository(int id);

    @Override
    String editInRepository(Customer customer);

    @Override
    Customer detailInRepository(int id);

    @Override
    List<Customer> findInRepository(String byName);

    @Override
    int countInRepository();

    @Override
    List<Customer> listLimitInRepository(int index, int getNumber);
}
