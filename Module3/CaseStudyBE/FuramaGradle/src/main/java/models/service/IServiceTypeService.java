package models.service;

import models.bean.ServiceType;

import java.util.List;

public interface IServiceTypeService extends IService<ServiceType> {
    @Override
    List<ServiceType> listInService();

    @Override
    String addInService(ServiceType serviceType);

    @Override
    String deleteInService(int id);

    @Override
    String editInService(ServiceType serviceType);

    @Override
    ServiceType detailInService(int id);

    @Override
    List<ServiceType> findInService(String byName);

    @Override
    int countInService();

    @Override
    List<ServiceType> listLimitInService(int index, int getNumber);
}
