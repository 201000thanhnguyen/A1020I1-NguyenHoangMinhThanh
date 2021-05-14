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
        return this.repository.deleteUser(id);
    }

    @Override
    public String editUser(User user) {
        return this.repository.editUser(user);
    }

    @Override
    public User detailUser(int id) {
        return this.repository.detailUser(id);
    }

    @Override
    public List<User> searchCountry(String country) {
        return this.repository.searchCountry(country);
    }

    @Override
    public List<User> sortNameASC() {
        return this.repository.sortNameASC();
    }

    @Override
    public List<User> sortNameDESC() {
        return this.repository.sortNameDESC();
    }
}
