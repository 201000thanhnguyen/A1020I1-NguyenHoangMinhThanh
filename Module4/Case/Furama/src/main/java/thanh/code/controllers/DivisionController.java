package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Division;
import thanh.code.models.ServiceType;
import thanh.code.service.IDivisionService;
import thanh.code.service.IServiceTypeService;

@Controller
@RequestMapping("/Division")
public class DivisionController {

    final IDivisionService divisionService;
    private final IServiceTypeService serviceTypeService;

    @ModelAttribute("serviceTypeIter")
    public Iterable<ServiceType> serviceTypeIterable(){
        return this.serviceTypeService.serviceTypeIterable();
    }

    public DivisionController(IDivisionService divisionService, IServiceTypeService serviceTypeService) {
        this.divisionService = divisionService;
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping({"/index", "/", ""})
    public ModelAndView index(){
        return new ModelAndView("/Division/index", "listDivision", this.divisionService.listEntity());
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
