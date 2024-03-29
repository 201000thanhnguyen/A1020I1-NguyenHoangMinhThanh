package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.RentType;
import thanh.code.models.ServiceType;
import thanh.code.service.IRentTypeService;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/RentType")
public class RentTypeController {

    private final IRentTypeService rentTypeService;

    public RentTypeController(IRentTypeService rentTypeService) {
        this.rentTypeService = rentTypeService;
    }

    @GetMapping
    public ResponseEntity<List<RentType>> get() {
        List<RentType> rentTypeList = this.rentTypeService.listEntity();
        if (rentTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(rentTypeList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<RentType> post(@RequestBody RentType rentType) {
        this.rentTypeService.addOrUpdateEntity(rentType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentType> detail(@PathVariable int id) {
        RentType rentType = this.rentTypeService.findByIdInt(id);
        if (rentType == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(rentType, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentType> update(@PathVariable int id, @RequestBody RentType rentType) {
        if (this.rentTypeService.findByIdInt(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.rentTypeService.addOrUpdateEntity(rentType);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RentType> delete(@PathVariable int id) {
        RentType rentType = this.rentTypeService.findByIdInt(id);
        if (rentType == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.rentTypeService.removeEntity(rentType);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
