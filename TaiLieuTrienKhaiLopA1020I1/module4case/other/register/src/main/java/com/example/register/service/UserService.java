package com.example.register.service;

import com.example.register.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> selectAllUser();
    //Optional<User> findByEmail(String email);
    User findByEmail(String email);
    void saveUser(User user);
    Boolean existsUserByEmail(String email);
}
