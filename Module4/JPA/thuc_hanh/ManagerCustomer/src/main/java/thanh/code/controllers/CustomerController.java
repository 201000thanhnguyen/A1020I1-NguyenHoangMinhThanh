package thanh.code.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import thanh.code.models.Customer;
import thanh.code.service.ICustomerService;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

    final ICustomerService _customerService;

    public CustomerController(
            ICustomerService customerService){
        _customerService = customerService;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/Customer/index");
        modelAndView.addObject("listCustomer", this._customerService.listCustomer());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/Customer/create", "customer", new Customer());
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("/Customer/index");
        modelAndView.addObject("msg", this._customerService.addCustomer(customer));
        modelAndView.addObject("listCustomer", this._customerService.listCustomer());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        return new ModelAndView("/Customer/index", "listCustomer", this._customerService.detailCustomer(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/Customer/index");
        modelAndView.addObject("msg", this._customerService.deleteCustomer(id));
        modelAndView.addObject("listCustomer", this._customerService.listCustomer());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/Customer/edit", "customer", this._customerService.detailCustomer(id));
    }
}
