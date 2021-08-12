package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Position;
import thanh.code.models.ServiceType;
import thanh.code.service.IPositionService;
import thanh.code.service.IServiceTypeService;

@Controller
@RequestMapping("/Position")
public class PositionController {

    final IPositionService positionService;
    private final IServiceTypeService serviceTypeService;

    @ModelAttribute("serviceTypeIter")
    public Iterable<ServiceType> serviceTypeIterable(){
        return this.serviceTypeService.serviceTypeIterable();
    }

    public PositionController(IPositionService positionService, IServiceTypeService serviceTypeService){
        this.positionService = positionService;
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping({"/index", "/", ""})
    public ModelAndView index(){
        return new ModelAndView("/Position/index", "listPosition", this.positionService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/Position/create", "position", new Position());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute Position position, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Position/create");
        }else {
            this.positionService.addOrUpdateEntity(position);
            return index();
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/Position/edit", "position", this.positionService.findByIdInt(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute Position position, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Position/edit");
        }else {
            this.positionService.addOrUpdateEntity(position);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        this.positionService.removeEntity(this.positionService.findByIdInt(id));
        return index();
    }
}
