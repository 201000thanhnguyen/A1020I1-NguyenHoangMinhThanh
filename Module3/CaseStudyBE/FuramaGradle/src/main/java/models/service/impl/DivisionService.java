package models.service.impl;

import models.bean.Division;
import models.repository.IDivisionRepository;
import models.repository.impl.DivisionRepository;
import models.service.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {
    IDivisionRepository divisionRepository = new DivisionRepository();

    @Override
    public List<Division> listInService() {
        return this.divisionRepository.listInRepository();
    }

    @Override
    public String addInService(Division division) {
        return null;
    }

    @Override
    public String deleteInService(int id) {
        return null;
    }

    @Override
    public String editInService(Division division) {
        return null;
    }

    @Override
    public Division detailInService(int id) {
        return null;
    }

    @Override
    public List<Division> findInService(String byName) {
        return null;
    }

    @Override
    public int countInService() {
        return 0;
    }

    @Override
    public List<Division> listLimitInService(int index, int getNumber) {
        return null;
    }
}
