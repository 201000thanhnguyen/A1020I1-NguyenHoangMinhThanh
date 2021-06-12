package top.minhthanh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/home")
public class Home {
    @GetMapping(value = "/index")
    public ModelAndView index(@RequestParam double usd){
        ModelAndView modelAndView = new ModelAndView("/home/index");
        double vnd;
        try {
            vnd = usd * 23000;
            modelAndView.addObject("vnd", vnd);
            modelAndView.addObject("usd", usd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return modelAndView;
    }
}
