package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Customer;
import thanh.code.models.CustomerType;
import thanh.code.models.ServiceType;
import thanh.code.service.ICustomerService;
import thanh.code.service.ICustomerTypeService;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@Controller
@RequestMapping("/api/Customer")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Customer>> get() {
        List<Customer> customerList = this.customerService.listEntity();
        if (customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Customer> post(@RequestBody Customer customer) {
        this.customerService.addOrUpdateEntity(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Customer> detail(@PathVariable int id) {
        Customer customer = this.customerService.findByIdInt(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Customer> update(Customer customer) {
        this.customerService.addOrUpdateEntity(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Customer> delete(@PathVariable int id) {
        Customer customer = this.customerService.findByIdInt(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.customerService.removeEntity(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
