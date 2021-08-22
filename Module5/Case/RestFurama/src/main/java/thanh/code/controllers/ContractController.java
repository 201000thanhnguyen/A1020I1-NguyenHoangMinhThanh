package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.*;
import thanh.code.service.*;

@RestController
@RequestMapping("/api/Contract")
public class ContractController {

    private final IContractService contractService;
    private final IEmployeeService employeeService;
    private final ICustomerService customerService;
    private final IServiceService serviceService;
    private final IServiceTypeService serviceTypeService;

    @ModelAttribute("serviceTypeIter")
    public Iterable<ServiceType> serviceTypeIterable(){
        return this.serviceTypeService.serviceTypeIterable();
    }

    @ModelAttribute("employeeIter")
    public Iterable<Employee> employeeIterable() {
        return this.employeeService.employeeIterable();
    }

    @ModelAttribute("customerIter")
    public Iterable<Customer> customerIterable() {
        return this.customerService.customerIterable();
    }

    @ModelAttribute("serviceIter")
    public Iterable<Service> serviceIterable() {
        return this.serviceService.serviceIterable();
    }

    public ContractController(IContractService contractService, IEmployeeService employeeService,
                              ICustomerService customerService, IServiceService serviceService,
                              IServiceTypeService serviceTypeService) {
        this.contractService = contractService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.serviceService = serviceService;
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping({"/index", "/", ""})
    public ModelAndView index() {
        return new ModelAndView("/Contract/index", "listContract", this.contractService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/Contract/create", "contract", new Contract());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Contract contract = this.contractService.findByIdInt(id);
        if (contract == null) {
            return index();
        } else {
            return new ModelAndView("/Contract/edit", "contract", contract);
        }
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute Contract contract, BindingResult bindingResult) {
        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/Contract/create");
        } else {
            this.contractService.addOrUpdateEntity(contract);
            return index();
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute Contract contract, BindingResult bindingResult) {
        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/Contract/edit");
        } else {
            this.contractService.addOrUpdateEntity(contract);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        this.contractService.removeEntity(this.contractService.findByIdInt(id));
        return index();
    }
}
