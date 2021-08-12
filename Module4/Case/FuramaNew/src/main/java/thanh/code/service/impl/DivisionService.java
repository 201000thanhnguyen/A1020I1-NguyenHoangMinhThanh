package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.Division;
import thanh.code.repository.IDivisionRepository;
import thanh.code.service.IDivisionService;

import java.util.List;

@Service
//@Component("DivisionService")
public class DivisionService implements IDivisionService {

    final IDivisionRepository divisionRepository;

    public DivisionService(IDivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @Override
    public List<Division> listEntity() {
        return this.divisionRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(Division division) {
        this.divisionRepository.save(division);
    }

    @Override
    public void removeEntity(Division division) {
        this.divisionRepository.delete(division);
    }

    @Override
    public Division findByIdInt(int id) {
        return this.divisionRepository.findById(id).orElse(null);
    }

    // for tag select option client
    @Override
    public Iterable<Division> divisionIterable() {
        return this.divisionRepository.findAll();
    }
}
