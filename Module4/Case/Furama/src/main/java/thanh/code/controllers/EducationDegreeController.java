package thanh.code.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.EducationDegree;
import thanh.code.service.ICRUDService;
import thanh.code.service.IEducationDegreeService;

@Controller
@RequestMapping("/EducationDegree")
public class EducationDegreeController {

    final IEducationDegreeService educationDegreeService;

    public EducationDegreeController(IEducationDegreeService educationDegreeService) {
        this.educationDegreeService = educationDegreeService;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/EducationDegree/index", "listEntity", this.educationDegreeService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/EducationDegree/create", "educationDegree", new EducationDegree());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute EducationDegree educationDegree, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/EducationDegree/create");
        }else {
            this.educationDegreeService.addOrUpdateEntity(educationDegree);
            return index();
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/EducationDegree/edit", "educationDegree", this.educationDegreeService.findByIdInt(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute EducationDegree educationDegree, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/EducationDegree/edit");
        }else {
            this.educationDegreeService.addOrUpdateEntity(educationDegree);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        this.educationDegreeService.removeEntity(this.educationDegreeService.findByIdInt(id));
        return index();
    }
}
