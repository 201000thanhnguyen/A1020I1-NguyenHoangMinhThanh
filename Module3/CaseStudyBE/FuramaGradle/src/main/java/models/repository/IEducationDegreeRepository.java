package models.repository;

import models.bean.EducationDegree;

import java.util.List;

public interface IEducationDegreeRepository extends IRepository<EducationDegree> {
    @Override
    List<EducationDegree> listInRepository();

    @Override
    String addInRepository(EducationDegree educationDegree);

    @Override
    String deleteInRepository(int id);

    @Override
    String editInRepository(EducationDegree educationDegree);

    @Override
    EducationDegree detailInRepository(int id);

    @Override
    List<EducationDegree> findInRepository(String byName);

    @Override
    int countInRepository();

    @Override
    List<EducationDegree> listLimitInRepository(int index, int getNumber);
}
