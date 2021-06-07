package models.repository;

import models.bean.Service;
import models.service.IService;

import java.util.List;

public interface IServiceService extends IService<Service> {
    @Override
    List<Service> listInService();

    @Override
    String addInService(Service service);

    @Override
    String deleteInService(int id);

    @Override
    String editInService(Service service);

    @Override
    Service detailInService(int id);

    @Override
    List<Service> findInService(String byName);

    @Override
    int countInService();

    @Override
    List<Service> listLimitInService(int index, int getNumber);
}
