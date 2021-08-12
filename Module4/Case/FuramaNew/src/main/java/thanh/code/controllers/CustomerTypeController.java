package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.CustomerType;
import thanh.code.service.ICustomerTypeService;

@Controller
@RequestMapping("/CustomerType")
public class CustomerTypeController {

    final ICustomerTypeService customerTypeService;

    public CustomerTypeController(ICustomerTypeService customerTypeService) {
        this.customerTypeService = customerTypeService;
    }

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("/CustomerType/index", "listCustomerType", this.customerTypeService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/CustomerType/create", "customerType", new CustomerType());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute CustomerType customerType, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/CustomerType/create");
        } else {
            this.customerTypeService.addOrUpdateEntity(customerType);
            return index();
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        CustomerType customerType = this.customerTypeService.findByIdInt(id);
        if (customerType == null) {
            return index();
        } else {
            return new ModelAndView("/CustomerType/edit", "customerType", customerType);
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute CustomerType customerType, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/CustomerType/edit");
        } else {
            this.customerTypeService.addOrUpdateEntity(customerType);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        this.customerTypeService.removeEntity(this.customerTypeService.findByIdInt(id));
        return index();
    }
}
