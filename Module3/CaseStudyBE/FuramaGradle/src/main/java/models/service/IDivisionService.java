package models.service;

import models.bean.Division;

import java.util.List;

public interface IDivisionService extends IService<Division> {
    @Override
    List<Division> listInService();

    @Override
    String addInService(Division division);

    @Override
    String deleteInService(int id);

    @Override
    String editInService(Division division);

    @Override
    Division detailInService(int id);

    @Override
    List<Division> findInService(String byName);

    @Override
    int countInService();

    @Override
    List<Division> listLimitInService(int index, int getNumber);
}
