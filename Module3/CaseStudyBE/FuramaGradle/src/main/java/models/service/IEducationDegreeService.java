package models.service;

import models.bean.EducationDegree;

import java.util.List;

public interface IEducationDegreeService extends IService<EducationDegree> {
    @Override
    List<EducationDegree> listInService();

    @Override
    String addInService(EducationDegree educationDegree);

    @Override
    String deleteInService(int id);

    @Override
    String editInService(EducationDegree educationDegree);

    @Override
    EducationDegree detailInService(int id);

    @Override
    List<EducationDegree> findInService(String byName);

    @Override
    int countInService();

    @Override
    List<EducationDegree> listLimitInService(int index, int getNumber);
}
