package thanh.code.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import thanh.code.models.Customer;
import thanh.code.service.ICustomerService;

import javax.jws.WebService;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    final ICustomerService customerService;

    public CustomerRestController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> list(){
        List<Customer> customerList = this.customerService.listEntity();
        if (customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> add(@RequestBody Customer customer){
        this.customerService.addOrUpdateEntity(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> update(@PathVariable int id, @RequestBody Customer customer){
        Customer customerUpdate = this.customerService.findByIdInt(id);
        if (customerUpdate == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            customerUpdate.setCustomerName(customer.getCustomerName());
            customerUpdate.setCustomerAge(customer.getCustomerAge());
            this.customerService.addOrUpdateEntity(customerUpdate);
            return new ResponseEntity<>(customerUpdate, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable int id){
        Customer customer = this.customerService.findByIdInt(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.customerService.removeEntity(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
