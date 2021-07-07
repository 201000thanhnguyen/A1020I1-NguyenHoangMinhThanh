package thanh.code.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thanh.code.models.People;

public interface IPeopleService extends ICRUDService<People> {

    public People detailEntityById(int id);

    public Page<People> listLimitEntity(Pageable pageable);
}
