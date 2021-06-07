package models.repository;

import models.bean.RentType;

import java.util.List;

public interface IRentTypeRepository extends IRepository<RentType> {
    @Override
    List<RentType> listInRepository();

    @Override
    String addInRepository(RentType rentType);

    @Override
    String deleteInRepository(int id);

    @Override
    String editInRepository(RentType rentType);

    @Override
    RentType detailInRepository(int id);

    @Override
    List<RentType> findInRepository(String byName);

    @Override
    int countInRepository();

    @Override
    List<RentType> listLimitInRepository(int index, int getNumber);
}
