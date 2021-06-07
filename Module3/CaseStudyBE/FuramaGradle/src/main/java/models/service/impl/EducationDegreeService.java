package models.service.impl;

import models.bean.EducationDegree;
import models.repository.IEducationDegreeRepository;
import models.repository.impl.EducationDegreeRepository;
import models.service.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();

    @Override
    public List<EducationDegree> listInService() {
        return this.educationDegreeRepository.listInRepository();
    }

    @Override
    public String addInService(EducationDegree educationDegree) {
        return null;
    }

    @Override
    public String deleteInService(int id) {
        return null;
    }

    @Override
    public String editInService(EducationDegree educationDegree) {
        return null;
    }

    @Override
    public EducationDegree detailInService(int id) {
        return null;
    }

    @Override
    public List<EducationDegree> findInService(String byName) {
        return null;
    }

    @Override
    public int countInService() {
        return 0;
    }

    @Override
    public List<EducationDegree> listLimitInService(int index, int getNumber) {
        return null;
    }
}
