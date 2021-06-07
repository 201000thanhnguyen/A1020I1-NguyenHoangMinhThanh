package models.service.impl;

import models.bean.Ground;
import models.repository.IGroundRepository;
import models.repository.impl.GroundRepository;
import models.service.IGroundService;

import java.util.List;

public class GroundService implements IGroundService {
    IGroundRepository repository = new GroundRepository();

    @Override
    public List<Ground> listInService() {
        return this.repository.listInRepository();
    }

    @Override
    public String addInService(Ground ground) {
        return null;
    }

    @Override
    public String deleteInService(String id) {
        return this.repository.deleteInRepository(id);
    }

    @Override
    public String editInService(Ground ground) {
        return null;
    }

    @Override
    public Ground detailInService(int id) {
        return null;
    }

    @Override
    public List<Ground> findInService(String byName) {
        return null;
    }

    @Override
    public int countInService() {
        return 0;
    }

    @Override
    public List<Ground> listLimitInService(int index, int getNumber) {
        return null;
    }
}
