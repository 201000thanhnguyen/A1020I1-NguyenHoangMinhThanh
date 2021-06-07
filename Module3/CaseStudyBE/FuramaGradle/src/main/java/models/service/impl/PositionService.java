package models.service.impl;

import models.bean.Position;
import models.repository.IPositionRepository;
import models.repository.impl.PositionRepository;
import models.service.IPositionService;

import java.util.List;

public class PositionService implements IPositionService {
    IPositionRepository positionRepository = new PositionRepository();

    @Override
    public List<Position> listInService() {
        return this.positionRepository.listInRepository();
    }

    @Override
    public String addInService(Position position) {
        return null;
    }

    @Override
    public String deleteInService(int id) {
        return null;
    }

    @Override
    public String editInService(Position position) {
        return null;
    }

    @Override
    public Position detailInService(int id) {
        return null;
    }

    @Override
    public List<Position> findInService(String byName) {
        return null;
    }

    @Override
    public int countInService() {
        return 0;
    }

    @Override
    public List<Position> listLimitInService(int index, int getNumber) {
        return null;
    }
}
