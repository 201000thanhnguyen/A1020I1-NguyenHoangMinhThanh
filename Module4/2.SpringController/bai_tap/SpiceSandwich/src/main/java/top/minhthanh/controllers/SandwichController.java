package top.minhthanh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.minhthanh.models.Sandwich;
import top.minhthanh.models.SandwichCondiment;
import top.minhthanh.service.ISandwichService;

@Controller
@RequestMapping(value = "/Sandwich")
public class SandwichController {
    @Autowired
    ISandwichService sandwichService;

    @GetMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/Sandwich/index");
        modelAndView.addObject("sandwichCondiment", SandwichCondiment.values());
        modelAndView.addObject("sandwich", new Sandwich());
        modelAndView.addObject("sandwichList", this.sandwichService.listSandwich());
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("sandwich") Sandwich sandwich){
        ModelAndView modelAndView = new ModelAndView("/Sandwich/index");
        this.sandwichService.addSandwich(sandwich);
        return index();
    }
}
