package top.minhthanh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.minhthanh.models.Customer;
import top.minhthanh.service.ICustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/Customer/index");
        modelAndView.addObject("listCustomer", this.customerService.listCustomer());
        return modelAndView;
    }

    @GetMapping(value = "/edit")
    public ModelAndView edit(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("/Customer/edit");
        modelAndView.addObject("customer", this.customerService.listCustomer().get(id));
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView edit(@RequestParam int id, @RequestParam String name,
                             @RequestParam String email, @RequestParam String address) {
        ModelAndView modelAndView = new ModelAndView("/Customer/index");
        this.customerService.editCustomer(new Customer(id, name, email, address));
        modelAndView.addObject("listCustomer", this.customerService.listCustomer());
        return modelAndView;
    }
}
