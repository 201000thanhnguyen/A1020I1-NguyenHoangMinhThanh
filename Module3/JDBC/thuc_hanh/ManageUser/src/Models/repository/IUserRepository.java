package Models.repository;

import Models.bean.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserRepository {
    List<User> listUser();

    String addUser(User user);

    String deleteUser(int id);

    String editUser(User user);

    User detailUser(int id);
}
