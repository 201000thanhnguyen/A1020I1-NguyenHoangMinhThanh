package models.service.impl;

import models.bean.Service;
import models.repository.IServiceRepository;
import models.repository.impl.ServiceRepository;
import models.service.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {
    IServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public List<Service> listInService() {
        return this.serviceRepository.listInService();
    }

    @Override
    public String addInService(Service service) {
        return this.serviceRepository.addInService(service);
    }

    @Override
    public String deleteInService(int id) {
        return null;
    }

    @Override
    public String editInService(Service service) {
        return null;
    }

    @Override
    public Service detailInService(int id) {
        return null;
    }

    @Override
    public List<Service> findInService(String byName) {
        return null;
    }

    @Override
    public int countInService() {
        return 0;
    }

    @Override
    public List<Service> listLimitInService(int index, int getNumber) {
        return null;
    }
}
