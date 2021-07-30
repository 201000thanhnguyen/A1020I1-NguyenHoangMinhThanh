package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Account;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping("/index")
    public ModelAndView index(@SessionAttribute(value = "permission", required = false) Account account){
        boolean check;
        check = checkAdminPermission(account);
        return check ? new ModelAndView("/Manager/index") : new ModelAndView("/index");
    }

    private boolean checkAdminPermission(@SessionAttribute(value = "permission", required = false) Account account) {
        boolean check;
        check = account.getAccountPermission().equals("admin");
        return check;
    }

}
