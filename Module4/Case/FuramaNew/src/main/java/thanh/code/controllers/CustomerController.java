package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Customer;
import thanh.code.models.CustomerType;
import thanh.code.service.ICustomerService;
import thanh.code.service.ICustomerTypeService;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

    final ICustomerService customerService;
    final ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypeIter")
    public Iterable<CustomerType> customerTypeIterable(){
        return this.customerTypeService.customerTypeIterable();
    }

    public CustomerController(ICustomerService customerService, ICustomerTypeService customerTypeService) {
        this.customerService = customerService;
        this.customerTypeService = customerTypeService;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/Customer/index", "listCustomer", this.customerService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/Customer/create", "customer", new Customer());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        Customer customer = this.customerService.findByIdInt(id);
        if (customer == null){
            return index();
        }else {
            return new ModelAndView("/Customer/edit", "customer", customer);
        }
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute Customer customer, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Customer/create");
        }else {
            this.customerService.addOrUpdateEntity(customer);
            return index();
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute Customer customer, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Customer/edit");
        }else {
            this.customerService.addOrUpdateEntity(customer);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        this.customerService.removeEntity(this.customerService.findByIdInt(id));
        return index();
    }
}
