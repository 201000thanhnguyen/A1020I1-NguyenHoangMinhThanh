package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.RentType;
import thanh.code.repository.IRentTypeRepository;
import thanh.code.service.IRentTypeService;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    final IRentTypeRepository rentTypeRepository;

    public RentTypeService(IRentTypeRepository rentTypeRepository) {
        this.rentTypeRepository = rentTypeRepository;
    }

    @Override
    public Iterable<RentType> rentTypeIterable() {
        return this.rentTypeRepository.findAll();
    }

    @Override
    public List<RentType> listEntity() {
        return this.rentTypeRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(RentType rentType) {
        this.rentTypeRepository.save(rentType);
    }

    @Override
    public void removeEntity(RentType rentType) {
        this.rentTypeRepository.delete(rentType);
    }

    @Override
    public RentType findByIdInt(int id) {
        return this.rentTypeRepository.findById(id).orElse(null);
    }
}
