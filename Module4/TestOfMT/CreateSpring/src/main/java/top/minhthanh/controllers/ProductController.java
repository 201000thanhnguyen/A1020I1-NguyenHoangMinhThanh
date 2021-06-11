package top.minhthanh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @GetMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/product/index");
        modelAndView.addObject("helloProduct", "Hello Product");
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("/product/add");
        return modelAndView;
    }

}
