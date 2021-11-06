package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.ServiceType;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/ServiceType")
public class ServiceTypeController {

    private final IServiceTypeService serviceTypeService;

    public ServiceTypeController(IServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceType>> get() {
        List<ServiceType> serviceTypeList = this.serviceTypeService.listEntity();
        if (serviceTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(serviceTypeList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<ServiceType> post(@RequestBody ServiceType serviceType) {
        this.serviceTypeService.addOrUpdateEntity(serviceType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceType> detail(@PathVariable int id) {
        ServiceType serviceType = this.serviceTypeService.findByIdInt(id);
        if (serviceType == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(serviceType, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceType> update(@PathVariable int id, @RequestBody ServiceType serviceType) {
        if (this.serviceTypeService.findByIdInt(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.serviceTypeService.addOrUpdateEntity(serviceType);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceType> delete(@PathVariable int id) {
        ServiceType serviceType = this.serviceTypeService.findByIdInt(id);
        if (serviceType == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.serviceTypeService.removeEntity(serviceType);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
