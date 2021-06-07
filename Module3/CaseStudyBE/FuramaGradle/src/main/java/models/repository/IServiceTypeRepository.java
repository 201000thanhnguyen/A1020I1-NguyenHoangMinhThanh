package models.repository;

import models.bean.ServiceType;

import java.util.List;

public interface IServiceTypeRepository extends IRepository<ServiceType> {
    @Override
    List<ServiceType> listInRepository();

    @Override
    String addInRepository(ServiceType serviceType);

    @Override
    String deleteInRepository(int id);

    @Override
    String editInRepository(ServiceType serviceType);

    @Override
    ServiceType detailInRepository(int id);

    @Override
    List<ServiceType> findInRepository(String byName);

    @Override
    int countInRepository();

    @Override
    List<ServiceType> listLimitInRepository(int index, int getNumber);
}
