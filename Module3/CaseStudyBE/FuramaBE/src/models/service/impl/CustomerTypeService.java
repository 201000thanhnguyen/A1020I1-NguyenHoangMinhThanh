package models.service.impl;

import models.bean.CustomerType;
import models.repository.ICustomerTypeRepository;
import models.repository.impl.CustomerTypeRepository;
import models.service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> listInService() {
        return this.customerTypeRepository.listInRepository();
    }

    @Override
    public String addInService(CustomerType customerType) {
        return null;
    }

    @Override
    public String deleteInService(int id) {
        return null;
    }

    @Override
    public String editInService(CustomerType customerType) {
        return null;
    }

    @Override
    public CustomerType detailInService(int id) {
        return null;
    }

    @Override
    public List<CustomerType> findInService(String byName) {
        return null;
    }
}
