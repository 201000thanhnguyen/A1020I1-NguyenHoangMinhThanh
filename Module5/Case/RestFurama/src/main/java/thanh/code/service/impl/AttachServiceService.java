package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.AttachService;
import thanh.code.repository.IAttachServiceRepository;
import thanh.code.service.IAttachServiceService;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {

    private final IAttachServiceRepository attachServiceRepository;

    public AttachServiceService(IAttachServiceRepository attachServiceRepository) {
        this.attachServiceRepository = attachServiceRepository;
    }

    @Override
    public Iterable<AttachService> attachServiceIterable() {
        return this.attachServiceRepository.findAll();
    }

    @Override
    public List<AttachService> listEntity() {
        return this.attachServiceRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(AttachService attachService) {
        this.attachServiceRepository.save(attachService);
    }

    @Override
    public void removeEntity(AttachService attachService) {
        this.attachServiceRepository.delete(attachService);
    }

    @Override
    public AttachService findByIdInt(int id) {
        return this.attachServiceRepository.findById(id).orElse(null);
    }
}
