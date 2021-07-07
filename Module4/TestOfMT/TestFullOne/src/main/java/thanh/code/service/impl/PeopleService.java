package thanh.code.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thanh.code.models.People;
import thanh.code.repository.IPeopleRepository;
import thanh.code.service.IPeopleService;

import java.util.List;

@Service
public class PeopleService implements IPeopleService {

    final IPeopleRepository _peopleRepository;

    public PeopleService(IPeopleRepository peopleRepository) {
        _peopleRepository = peopleRepository;
    }

    @Override
    public List<People> listEntity() {
        return this._peopleRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(People people) {
        this._peopleRepository.save(people);
    }

    @Override
    public void removeEntity(People people) {
        this._peopleRepository.delete(people);
    }

    public People detailEntityById(int id){
        return this._peopleRepository.findById(id).orElse(null);
    }

    public Page<People> listLimitEntity(Pageable pageable){
      return this._peopleRepository.findAll(pageable);
    }
}
