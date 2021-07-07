package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.User;
import thanh.code.repository.IUserRepository;
import thanh.code.service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {
    final IUserRepository _userRepository;

    public UserService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public List<User> listEntity() {
        return this._userRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(User user) {
        this._userRepository.save(user);
    }

    @Override
    public void removeEntity(User user) {
        this._userRepository.delete(user);
    }

    @Override
    public User detailEntityByIdInteger(int id) {
        return this._userRepository.findById(id).orElse(null);
    }
}
