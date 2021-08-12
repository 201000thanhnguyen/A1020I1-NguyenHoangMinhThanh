package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.Role;
import thanh.code.repository.IRoleRepository;
import thanh.code.service.IRoleService;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    final IRoleRepository roleRepository;

    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Iterable<Role> roleIterable() {
        return this.roleRepository.findAll();
    }

    @Override
    public List<Role> listEntity() {
        return this.roleRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    public void removeEntity(Role role) {
        this.roleRepository.delete(role);
    }

    @Override
    public Role findByIdInt(int id) {
        return this.roleRepository.findById(id).orElse(null);
    }
}
