package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Account;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// lưu ý " biến siêu toàn cục không thể hiển thị tại 1 nơi không có liên kết request
// ví dụ xóa @GetMapping("/login") thì tại trang login.html sẽ không nhận được biến siêu toàn cục
@Controller
@SessionAttributes("permission")
public class HomeController {

    @ModelAttribute("permission")
    public Account setPermission() {
        return new Account();
    }

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("/index");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("permission") Account account) {
        if (account.getAccountName().equals("admin")  && account.getAccountPassword().equals("admin")){
            account.setAccountPermission("admin");
        }else {
            account.setAccountPermission("user");
        }
        System.out.println(account);
        return index();
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session){
        session.invalidate();
        return index();
    }
}
