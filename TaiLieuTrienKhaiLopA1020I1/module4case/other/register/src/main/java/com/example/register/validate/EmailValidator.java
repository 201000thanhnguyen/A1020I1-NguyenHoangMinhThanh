package com.example.register.validate;

import com.example.register.dao.UserRepository;
import com.example.register.model.User;
import com.example.register.service.UserService;
import com.example.register.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmailValidator implements ConstraintValidator<EmailConstaint, String> {
    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;
    @Override
    public void initialize(EmailConstaint constraintAnnotation) {
        constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
//            Do cái findByEmail nó null a
//        Nó phải là findBYNameEmail. vì lúc này email chưa được tạo.
//        return !userRepository.existsUserByEmail(email);
        if (userService != null){
            return userService.findByEmail(email) == null;
        }

        return true;

    }

}
