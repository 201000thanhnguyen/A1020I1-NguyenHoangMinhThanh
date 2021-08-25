package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Division;
import thanh.code.models.ServiceType;
import thanh.code.service.IDivisionService;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@Controller
@RequestMapping("/Division")
public class DivisionController {

    private final IDivisionService divisionService;

    public DivisionController(IDivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Division>> get() {
        List<Division> divisionList = this.divisionService.listEntity();
        if (divisionList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(divisionList, HttpStatus.OK);
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
