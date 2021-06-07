package models.service;

import models.bean.Position;

import java.util.List;

public interface IPositionService extends IService<Position> {
    @Override
    List<Position> listInService();

    @Override
    String addInService(Position position);

    @Override
    String deleteInService(int id);

    @Override
    String editInService(Position position);

    @Override
    Position detailInService(int id);

    @Override
    List<Position> findInService(String byName);

    @Override
    int countInService();

    @Override
    List<Position> listLimitInService(int index, int getNumber);
}
