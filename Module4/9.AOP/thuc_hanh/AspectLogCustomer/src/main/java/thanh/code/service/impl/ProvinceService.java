package thanh.code.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thanh.code.models.Province;
import thanh.code.repository.IProvinceRepository;
import thanh.code.service.IProvinceService;

@Service
public class ProvinceService implements IProvinceService {

    @Autowired
    IProvinceRepository provinceRepository;

    @Override
    public Page<Province> findAllPage(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
