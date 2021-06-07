package models.service;

import models.bean.RentType;

import java.util.List;

public interface IRentTypeService extends IService<RentType> {
    @Override
    List<RentType> listInService();

    @Override
    String addInService(RentType rentType);

    @Override
    String deleteInService(int id);

    @Override
    String editInService(RentType rentType);

    @Override
    RentType detailInService(int id);

    @Override
    List<RentType> findInService(String byName);

    @Override
    int countInService();

    @Override
    List<RentType> listLimitInService(int index, int getNumber);
}
