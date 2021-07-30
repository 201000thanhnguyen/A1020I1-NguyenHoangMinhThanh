package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Account;

@Controller
public class TestController {

    @GetMapping("/test")
    public ModelAndView test(@SessionAttribute(value = "permission", required = false) Account account){
        System.out.println(account);
        return new ModelAndView("/test");
    }
}
