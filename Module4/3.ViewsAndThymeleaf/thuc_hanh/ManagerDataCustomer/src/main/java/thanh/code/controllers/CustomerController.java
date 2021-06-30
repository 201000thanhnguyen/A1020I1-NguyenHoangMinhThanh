package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Customer;
import thanh.code.service.ICustomerService;

@Controller
@RequestMapping(value = "/Customer")
public class CustomerController {

    final ICustomerService _customerService;

    public CustomerController(ICustomerService customerService){
        _customerService = customerService;
    }

    @GetMapping(value = "/index")
    public ModelAndView index(String msg){
        ModelAndView modelAndView = new ModelAndView("/Customer/index");
        modelAndView.addObject("listCustomer", this._customerService.listEntity());

        modelAndView.addObject("msg", msg);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/Customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Customer customer){
        String msg = this._customerService.addEntity(customer);
        return index(msg);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/Customer/edit");
        modelAndView.addObject("arrLanguage", new String[]{"VN","EN"});
        modelAndView.addObject("customer", this._customerService.findEntity(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Customer customer){

        return index(null);
    }
}
