package thanh.code.service;

import thanh.code.models.Service;

import java.util.List;

public interface IServiceService extends ICRUDService<Service> {

    Iterable<Service> serviceIterable();
    List<Service> findServiceByServiceTypeName(String serviceTypeName);
}
