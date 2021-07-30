package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.RentType;
import thanh.code.service.IRentTypeService;

@Controller
@RequestMapping("/RentType")
public class RentTypeController {

    final IRentTypeService rentTypeService;

    public RentTypeController(IRentTypeService rentTypeService) {
        this.rentTypeService = rentTypeService;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/RentType/index", "listRentType", this.rentTypeService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/RentType/create", "rentType", new RentType());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/RentType/edit", "rentType", this.rentTypeService.findByIdInt(id));
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute RentType rentType, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/RentType/create");
        }else {
            this.rentTypeService.addOrUpdateEntity(rentType);
            return index();
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute RentType rentType, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/RentType/edit");
        }else {
            this.rentTypeService.addOrUpdateEntity(rentType);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        this.rentTypeService.removeEntity(this.rentTypeService.findByIdInt(id));
        return index();
    }
}
