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
@RequestMapping("/api/Service")
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
    public ResponseEntity<Service> post(@RequestBody Service service) {
        this.serviceService.addOrUpdateEntity(service);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Service> detail(@PathVariable int id) {
        Service service = this.serviceService.findByIdInt(id);
        if (service == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(service, HttpStatus.OK);
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Service> update(@RequestBody Service service) {
        this.serviceService.addOrUpdateEntity(service);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Service> delete(@PathVariable int id) {
        Service service = this.serviceService.findByIdInt(id);
        if (service == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.serviceService.removeEntity(service);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
