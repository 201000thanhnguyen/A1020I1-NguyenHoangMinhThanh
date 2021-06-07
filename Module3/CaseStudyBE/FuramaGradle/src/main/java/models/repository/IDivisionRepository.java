package models.repository;

import models.bean.Division;

import java.util.List;

public interface IDivisionRepository extends IRepository<Division> {
    @Override
    List<Division> listInRepository();

    @Override
    String addInRepository(Division division);

    @Override
    String deleteInRepository(int id);

    @Override
    String editInRepository(Division division);

    @Override
    Division detailInRepository(int id);

    @Override
    List<Division> findInRepository(String byName);

    @Override
    int countInRepository();

    @Override
    List<Division> listLimitInRepository(int index, int getNumber);
}
