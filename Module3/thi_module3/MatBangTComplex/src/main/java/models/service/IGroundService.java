package models.service;

import models.bean.Ground;

import java.util.List;

public interface IGroundService extends IService<Ground> {
    @Override
    List<Ground> listInService();

    @Override
    String addInService(Ground ground);

    @Override
    String deleteInService(String id);

    @Override
    String editInService(Ground ground);

    @Override
    Ground detailInService(int id);

    @Override
    List<Ground> findInService(String byName);

    @Override
    int countInService();

    @Override
    List<Ground> listLimitInService(int index, int getNumber);
}
