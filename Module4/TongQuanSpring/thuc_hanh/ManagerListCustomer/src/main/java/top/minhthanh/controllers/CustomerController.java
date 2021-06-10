package top.minhthanh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import top.minhthanh.service.ICustomerService;

@Controller
@RequestMapping(value = "/Customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/Customer/index");
        modelAndView.addObject("listCustomer", this.customerService.listCustomer());
        return modelAndView;
        try {

        }catch (SpringE)
    }
}
