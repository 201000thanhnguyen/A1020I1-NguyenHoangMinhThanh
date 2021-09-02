package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.EducationDegree;
import thanh.code.models.ServiceType;
import thanh.code.service.IEducationDegreeService;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@Controller
@RequestMapping("/api/EducationDegree")
public class EducationDegreeController {

    private final IEducationDegreeService educationDegreeService;

    public EducationDegreeController(IEducationDegreeService educationDegreeService) {
        this.educationDegreeService = educationDegreeService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<EducationDegree>> get() {
        List<EducationDegree> educationDegreeList = this.educationDegreeService.listEntity();
        if (educationDegreeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(educationDegreeList, HttpStatus.OK);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<EducationDegree> post(@RequestBody EducationDegree educationDegree) {
        this.educationDegreeService.addOrUpdateEntity(educationDegree);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<EducationDegree> detail(@PathVariable int id) {
        EducationDegree educationDegree = this.educationDegreeService.findByIdInt(id);
        if (educationDegree == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(educationDegree, HttpStatus.OK);
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<EducationDegree> update(@RequestBody EducationDegree educationDegree) {
        this.educationDegreeService.addOrUpdateEntity(educationDegree);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<EducationDegree> delete(@PathVariable int id) {
        EducationDegree educationDegree = this.educationDegreeService.findByIdInt(id);
        if (educationDegree == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.educationDegreeService.removeEntity(educationDegree);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
