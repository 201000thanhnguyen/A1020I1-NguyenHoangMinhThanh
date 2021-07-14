package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Division;
import thanh.code.service.IDivisionService;

@Controller
@RequestMapping("/Division")
public class DivisionController {

    final IDivisionService divisionService;

    public DivisionController(IDivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/Division/index", "listEntity", this.divisionService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/Division/create", "division", new Division());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute Division division, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Division/create");
        }else {
            this.divisionService.addOrUpdateEntity(division);
            return index();
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/Division/edit", "division", this.divisionService.findByIdInt(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute Division division, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Division/edit");
        }else {
            this.divisionService.addOrUpdateEntity(division);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        this.divisionService.removeEntity(this.divisionService.findByIdInt(id));
        return index();
    }
}
