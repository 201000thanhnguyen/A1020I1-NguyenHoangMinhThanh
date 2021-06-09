package top.minhthanh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/product/index");
        modelAndView.addObject("helloProduct", "Hello Product");
        return modelAndView;
    }

    @RequestMapping(value = "/index/{name}")
    public ModelAndView index(@PathVariable String name){
        ModelAndView modelAndView = new ModelAndView("/product/index");
        modelAndView.addObject("helloProduct", name);
        return modelAndView;
    }

}
