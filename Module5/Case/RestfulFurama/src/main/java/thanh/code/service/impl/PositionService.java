package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.Position;
import thanh.code.repository.IPositionRepository;
import thanh.code.service.IPositionService;

import java.util.List;

@Service
//@Component("PositionService")
public class PositionService implements IPositionService {

    final IPositionRepository positionRepository;

    public PositionService(IPositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> listEntity() {
        return this.positionRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(Position position) {
        this.positionRepository.save(position);
    }

    @Override
    public void removeEntity(Position position) {
        this.positionRepository.delete(position);
    }

    @Override
    public Position findByIdInt(int id) {
        return this.positionRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Position> positionIterable() {
        return this.positionRepository.findAll();
    }
}
