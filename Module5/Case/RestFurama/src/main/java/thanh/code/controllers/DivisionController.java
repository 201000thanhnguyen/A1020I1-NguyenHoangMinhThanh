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

@RestController
@RequestMapping("/api/Division")
public class DivisionController {

    private final IDivisionService divisionService;

    public DivisionController(IDivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping
    public ResponseEntity<List<Division>> get() {
        List<Division> divisionList = this.divisionService.listEntity();
        if (divisionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(divisionList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Division> post(@RequestBody Division division) {
        this.divisionService.addOrUpdateEntity(division);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Division> detail(@PathVariable int id) {
        Division division = this.divisionService.findByIdInt(id);
        if (division == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(division, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Division> update(@PathVariable int id, @RequestBody Division division) {
        if (this.divisionService.findByIdInt(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.divisionService.addOrUpdateEntity(division);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Division> delete(@PathVariable int id) {
        Division division = this.divisionService.findByIdInt(id);
        if (division == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.divisionService.removeEntity(division);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
