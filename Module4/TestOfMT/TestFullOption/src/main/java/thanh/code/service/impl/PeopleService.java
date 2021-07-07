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

    public PeopleService(IPeopleRepository peopleRepository){
        _peopleRepository = peopleRepository;
    }

    @Override
    public List<People> listPeople() {
        return this._peopleRepository.findAll();
    }

    @Override
    public People findById(int id) {
        return this._peopleRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePeopleById(int id) {
        this._peopleRepository.deleteById(id);
    }

    @Override
    public void addPeople(People people) {
        this._peopleRepository.save(people);
    }

    @Override
    public Page<People> listLimitPeople(Pageable pageable) {
        return this._peopleRepository.findAll(pageable);
    }
}
