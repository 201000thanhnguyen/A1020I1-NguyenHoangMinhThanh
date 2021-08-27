package thanh.code.service;

import thanh.code.models.ServiceType;

public interface IServiceTypeService extends ICRUDService<ServiceType> {

    Iterable<ServiceType> serviceTypeIterable();
}
