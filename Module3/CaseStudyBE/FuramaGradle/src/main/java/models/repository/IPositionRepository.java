package models.repository;

import models.bean.Position;

import java.util.List;

public interface IPositionRepository extends IRepository<Position> {

    @Override
    List<Position> listInRepository();

    @Override
    String addInRepository(Position position);

    @Override
    String deleteInRepository(int id);

    @Override
    String editInRepository(Position position);

    @Override
    Position detailInRepository(int id);

    @Override
    List<Position> findInRepository(String byName);

    @Override
    int countInRepository();

    @Override
    List<Position> listLimitInRepository(int index, int getNumber);
}
