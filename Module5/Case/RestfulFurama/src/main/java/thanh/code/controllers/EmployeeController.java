package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.*;
import thanh.code.service.*;

import java.util.List;


@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> get() {
        List<Employee> employeeList = this.employeeService.listEntity();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Employee> post(@RequestBody Employee employee) {
        this.employeeService.addOrUpdateEntity(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> detail(@PathVariable int id) {
        Employee employee = this.employeeService.findByIdInt(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employee) {
        if (this.employeeService.findByIdInt(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.employeeService.addOrUpdateEntity(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable int id) {
        Employee employee = this.employeeService.findByIdInt(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.employeeService.removeEntity(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
