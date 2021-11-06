package thanh.code.service;

import thanh.code.models.CustomerType;

public interface ICustomerTypeService extends ICRUDService<CustomerType> {

    Iterable<CustomerType> customerTypeIterable();
}
