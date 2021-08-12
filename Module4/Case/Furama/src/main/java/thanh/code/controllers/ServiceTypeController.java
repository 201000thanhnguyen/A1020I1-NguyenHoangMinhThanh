package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.ServiceType;
import thanh.code.service.IServiceTypeService;

@Controller
@RequestMapping("/ServiceType")
public class ServiceTypeController {

    final IServiceTypeService serviceTypeService;

    @ModelAttribute("serviceTypeIter")
    public Iterable<ServiceType> serviceTypeIterable(){
        return this.serviceTypeService.serviceTypeIterable();
    }

    public ServiceTypeController(IServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping({"/index", "/", ""})
    public ModelAndView index(){
        return new ModelAndView("/ServiceType/index", "listServiceType", this.serviceTypeService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/ServiceType/create", "serviceType", new ServiceType());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute ServiceType serviceType, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/ServiceType/create");
        }else {
            this.serviceTypeService.addOrUpdateEntity(serviceType);
            return index();
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/ServiceType/edit", "serviceType", this.serviceTypeService.findByIdInt(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute ServiceType serviceType, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/ServiceType/edit");
        }else {
            this.serviceTypeService.addOrUpdateEntity(serviceType);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        this.serviceTypeService.removeEntity(this.serviceTypeService.findByIdInt(id));
        return index();
    }
}
