package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.Phone;
import thanh.code.repository.IPhoneRepository;
import thanh.code.service.IPhoneService;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {

    final IPhoneRepository phoneRepository;

    public PhoneService(IPhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<Phone> listEntity() {
        return this.phoneRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(Phone phone) {
        this.phoneRepository.save(phone);
    }

    @Override
    public void removeEntity(Phone phone) {
        this.phoneRepository.delete(phone);
    }

    @Override
    public Phone findByIdInt(int id) {
        return this.phoneRepository.findById(id).orElse(null);
    }
}
