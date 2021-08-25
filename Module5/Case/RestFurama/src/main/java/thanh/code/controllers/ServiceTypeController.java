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

@Controller
@RequestMapping("/ServiceType")
public class ServiceTypeController {

    private final IServiceTypeService serviceTypeService;

    public ServiceTypeController(IServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ServiceType>> get() {
        List<ServiceType> serviceTypeList = this.serviceTypeService.listEntity();
        if (serviceTypeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(serviceTypeList, HttpStatus.OK);
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
