package com.example.register.controller;

import com.example.register.model.User;
import com.example.register.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Service
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String loadRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/saveregister")
    public String saveRegister(@Validated @ModelAttribute User user, BindingResult bindingResult) {
        new User().validate(user, bindingResult);
        // if (bindingResult.hasErrors()) {
        if (bindingResult.hasFieldErrors()) {
            return "register";
        }
        userService.saveUser(user);
        System.out.println(user);
        return "success";
    }
}
