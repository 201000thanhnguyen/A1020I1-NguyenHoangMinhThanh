package thanh.code.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thanh.code.models.Province;

public interface IProvinceService {
    Page<Province> findAllPage(Pageable pageable);

    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
