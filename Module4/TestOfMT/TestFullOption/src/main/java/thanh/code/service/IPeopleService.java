package thanh.code.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thanh.code.models.People;

import java.util.List;

public interface IPeopleService {
    List<People> listPeople();

    People findById(int id);

    void deletePeopleById(int id);

    void addPeople(People people);

    Page<People> listLimitPeople(Pageable pageable);
}
