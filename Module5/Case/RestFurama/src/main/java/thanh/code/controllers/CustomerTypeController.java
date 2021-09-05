package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.CustomerType;
import thanh.code.models.ServiceType;
import thanh.code.service.ICustomerTypeService;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/CustomerType")
public class CustomerTypeController {

    private final ICustomerTypeService customerTypeService;

    public CustomerTypeController(ICustomerTypeService customerTypeService) {
        this.customerTypeService = customerTypeService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerType>> get() {
        List<CustomerType> customerTypeList = this.customerTypeService.listEntity();
        if (customerTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerTypeList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<CustomerType> post(@RequestBody CustomerType customerType) {
        this.customerTypeService.addOrUpdateEntity(customerType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerType> detail(@PathVariable int id) {
        CustomerType customerType = this.customerTypeService.findByIdInt(id);
        if (customerType == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerType, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerType> update(@PathVariable int id, @RequestBody CustomerType customerType) {
        if (this.customerTypeService.findByIdInt(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.customerTypeService.addOrUpdateEntity(customerType);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerType> delete(@PathVariable int id) {
        CustomerType customerType = this.customerTypeService.findByIdInt(id);
        if (customerType == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.customerTypeService.removeEntity(customerType);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
