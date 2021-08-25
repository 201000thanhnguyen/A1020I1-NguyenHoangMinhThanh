package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.RentType;
import thanh.code.models.Service;
import thanh.code.models.ServiceType;
import thanh.code.service.IRentTypeService;
import thanh.code.service.IServiceService;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@Controller
@RequestMapping("/Service")
public class ServiceController {

    private final IServiceService serviceService;

    public ServiceController(IServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Service>> get() {
        List<Service> serviceList = this.serviceService.listEntity();
        if (serviceList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(serviceList, HttpStatus.OK);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> post() {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> detail(@PathVariable int id) {
        return null;
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<String> update(String string) {
        return null;
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(int id) {
        return null;
    }
}
