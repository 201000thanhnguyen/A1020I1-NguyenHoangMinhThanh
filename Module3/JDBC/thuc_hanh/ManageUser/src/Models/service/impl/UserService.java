package Models.service.impl;

import Models.bean.User;
import Models.repository.IUserRepository;
import Models.repository.impl.UserRepository;
import Models.service.IUserService;

import java.util.List;

public class UserService implements IUserService {

    IUserRepository repository = new UserRepository();

    @Override
    public List<User> listUser() {
        return this.repository.listUser();
    }

    @Override
    public String addUser(User user) {
        return this.repository.addUser(user);
    }

    @Override
    public String deleteUser(int id) {
        return null;
    }

    @Override
    public String editUser(User user) {
        return null;
    }

    @Override
    public String detailUser(int id) {
        return null;
    }
}
