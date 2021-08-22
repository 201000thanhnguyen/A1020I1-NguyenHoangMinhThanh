package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.repository.IServiceRepository;
import thanh.code.service.IServiceService;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    final IServiceRepository serviceRepository;

    public ServiceService(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<thanh.code.models.Service> listEntity() {
        return this.serviceRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(thanh.code.models.Service service) {
        this.serviceRepository.save(service);
    }

    @Override
    public void removeEntity(thanh.code.models.Service service) {
        this.serviceRepository.delete(service);
    }

    @Override
    public thanh.code.models.Service findByIdInt(int id) {
        return this.serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<thanh.code.models.Service> serviceIterable() {
        return this.serviceRepository.findAll();
    }

    @Override
    public List<thanh.code.models.Service> findServiceByServiceTypeName(String serviceTypeName) {
        return this.serviceRepository.findServiceByServiceTypeServiceTypeName(serviceTypeName);
    }
}
