package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.ServiceType;
import thanh.code.repository.IServiceTypeRepository;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {

    final IServiceTypeRepository serviceTypeRepository;

    public ServiceTypeService(IServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }

    @Override
    public Iterable<ServiceType> serviceTypeIterable() {
        return this.serviceTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> listEntity() {
        return this.serviceTypeRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(ServiceType serviceType) {
        this.serviceTypeRepository.save(serviceType);
    }

    @Override
    public void removeEntity(ServiceType serviceType) {
        this.serviceTypeRepository.delete(serviceType);
    }

    @Override
    public ServiceType findByIdInt(int id) {
        return this.serviceTypeRepository.findById(id).orElse(null);
    }
}
