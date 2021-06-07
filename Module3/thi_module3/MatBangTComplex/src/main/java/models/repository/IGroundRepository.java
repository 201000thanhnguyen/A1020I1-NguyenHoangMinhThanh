package models.repository;

import models.bean.Ground;

import java.util.List;

public interface IGroundRepository extends IRepository<Ground> {
    @Override
    List<Ground> listInRepository();

    @Override
    String addInRepository(Ground ground);

    @Override
    String deleteInRepository(String id);

    @Override
    String editInRepository(Ground ground);

    @Override
    Ground detailInRepository(int id);

    @Override
    List<Ground> findInRepository(String byName);

    @Override
    int countInRepository();

    @Override
    List<Ground> listLimitInRepository(int index, int getNumber);
}
