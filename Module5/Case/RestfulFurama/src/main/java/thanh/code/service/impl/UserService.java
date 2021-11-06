package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.User;
import thanh.code.repository.IUserRepository;
import thanh.code.service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listEntity() {
        return this.userRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void removeEntity(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public User findByIdInt(int id) {
        return null;
    }

    @Override
    public User findByIdString(String id) {
        return this.userRepository.findById(id).orElse(null);
    }
}
