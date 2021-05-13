package Models.service;

import Models.bean.User;

import java.util.List;

public interface IUserService {
    List<User> listUser();

    String addUser(User user);

    String deleteUser(int id);

    String editUser(User user);

    User detailUser(int id);
}
