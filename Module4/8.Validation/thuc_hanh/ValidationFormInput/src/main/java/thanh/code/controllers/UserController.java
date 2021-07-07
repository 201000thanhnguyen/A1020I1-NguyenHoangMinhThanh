package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.User;
import thanh.code.service.IUserService;

@Controller
@RequestMapping("/User")
public class UserController {
    final IUserService _userService;

    public UserController(IUserService userService) {
        _userService = userService;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/User/index", "listUser", this._userService.listEntity());
    }

    @GetMapping("create")
    public ModelAndView create(){
        return new ModelAndView("/User/create", "user", new User());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/User/create");
        }else {
            this._userService.addOrUpdateEntity(user);
            return new ModelAndView("/User/index", "listUser", this._userService.listEntity());
        }
    }
}
