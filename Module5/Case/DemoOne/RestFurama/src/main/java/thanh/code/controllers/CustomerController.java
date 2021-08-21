package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanh.code.models.Customer;
import thanh.code.service.ICustomerService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api")
public class CustomerController {

    final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> get(){
        List<Customer> customerList = this.customerService.listEntity();
        if(customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> get(@PathVariable int id){
        Customer customer = this.customerService.findByIdInt(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> post(@RequestBody Customer customer){
        this.customerService.addOrUpdateEntity(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> put(@PathVariable int id, @RequestBody Customer customer){
        Customer customer1 = this.customerService.findByIdInt(id);
        if (customer1 == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            customer1.setFirstName(customer.getFirstName());
            customer1.setLastName(customer.getLastName());
            this.customerService.addOrUpdateEntity(customer1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/customer/{id}")
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
