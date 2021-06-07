package models.service.impl;

import models.bean.RentType;
import models.repository.IRentTypeRepository;
import models.repository.impl.RentTypeRepository;
import models.service.IRentTypeService;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    IRentTypeRepository rentTypeRepository = new RentTypeRepository();

    @Override
    public List<RentType> listInService() {
        return this.rentTypeRepository.listInRepository();
    }

    @Override
    public String addInService(RentType rentType) {
        return null;
    }

    @Override
    public String deleteInService(int id) {
        return null;
    }

    @Override
    public String editInService(RentType rentType) {
        return null;
    }

    @Override
    public RentType detailInService(int id) {
        return null;
    }

    @Override
    public List<RentType> findInService(String byName) {
        return null;
    }

    @Override
    public int countInService() {
        return 0;
    }

    @Override
    public List<RentType> listLimitInService(int index, int getNumber) {
        return null;
    }
}
