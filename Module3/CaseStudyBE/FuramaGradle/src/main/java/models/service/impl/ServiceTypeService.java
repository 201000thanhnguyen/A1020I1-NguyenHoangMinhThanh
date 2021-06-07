package models.service.impl;

import models.bean.ServiceType;
import models.repository.IServiceTypeRepository;
import models.repository.impl.ServiceTypeRepository;
import models.service.IServiceTypeService;

import java.util.List;

public class ServiceTypeService implements IServiceTypeService {
    IServiceTypeRepository serviceTypeRepository = new ServiceTypeRepository();

    @Override
    public List<ServiceType> listInService() {
        return this.serviceTypeRepository.listInRepository();
    }

    @Override
    public String addInService(ServiceType serviceType) {
        return null;
    }

    @Override
    public String deleteInService(int id) {
        return null;
    }

    @Override
    public String editInService(ServiceType serviceType) {
        return null;
    }

    @Override
    public ServiceType detailInService(int id) {
        return null;
    }

    @Override
    public List<ServiceType> findInService(String byName) {
        return null;
    }

    @Override
    public int countInService() {
        return 0;
    }

    @Override
    public List<ServiceType> listLimitInService(int index, int getNumber) {
        return null;
    }
}
