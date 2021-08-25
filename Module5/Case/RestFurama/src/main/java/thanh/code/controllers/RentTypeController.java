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

@Controller
@RequestMapping("/RentType")
public class RentTypeController {

    private final IRentTypeService rentTypeService;

    public RentTypeController(IRentTypeService rentTypeService) {
        this.rentTypeService = rentTypeService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<RentType>> get() {
        List<RentType> rentTypeList = this.rentTypeService.listEntity();
        if (rentTypeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(rentTypeList, HttpStatus.OK);
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
