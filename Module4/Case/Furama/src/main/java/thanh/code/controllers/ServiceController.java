package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.RentType;
import thanh.code.models.Service;
import thanh.code.models.ServiceType;
import thanh.code.service.IRentTypeService;
import thanh.code.service.IServiceService;
import thanh.code.service.IServiceTypeService;

@Controller
@RequestMapping("/Service")
public class ServiceController {

    final IServiceService serviceService;
    final IServiceTypeService serviceTypeService;
    final IRentTypeService rentTypeService;

    @ModelAttribute("serviceTypeIter")
    public Iterable<ServiceType> serviceTypeIterable(){
        return this.serviceTypeService.serviceTypeIterable();
    }

    @ModelAttribute("rentTypeIter")
    public Iterable<RentType> rentTypeIterable(){
        return this.rentTypeService.rentTypeIterable();
    }

    public ServiceController(IServiceService serviceService, IServiceTypeService serviceTypeService,
                             IRentTypeService rentTypeService) {
        this.serviceService = serviceService;
        this.serviceTypeService = serviceTypeService;
        this.rentTypeService = rentTypeService;
    }

    @GetMapping({"/index", "/", ""})
    public ModelAndView index() {
        return new ModelAndView("/Service/index", "listService", this.serviceService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/Service/create", "service", new Service());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute Service service, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Service/create");
        }else {
            this.serviceService.addOrUpdateEntity(service);
            return index();
        }
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        return new ModelAndView("/Service/detail", "service", this.serviceService.findByIdInt(id));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Service service = this.serviceService.findByIdInt(id);
        if (service == null){
            return index();
        }else {
            return new ModelAndView("/Service/edit", "service", service);
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute Service service, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Service/edit");
        }else {
            this.serviceService.addOrUpdateEntity(service);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        this.serviceService.removeEntity(this.serviceService.findByIdInt(id));
        return index();
    }

    @GetMapping("/list/{serviceTypeName}")
    public ModelAndView list(@PathVariable String serviceTypeName){
        return new ModelAndView("/Service/list", "listService", this.serviceService.findServiceByServiceTypeName(serviceTypeName));
    }
}
