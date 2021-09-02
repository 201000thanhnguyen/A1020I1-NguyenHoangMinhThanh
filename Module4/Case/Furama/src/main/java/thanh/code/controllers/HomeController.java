package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.ServiceType;
import thanh.code.service.IServiceTypeService;


@Controller
public class HomeController {

    private final IServiceTypeService serviceTypeService;

    @ModelAttribute("serviceTypeIter")
    public Iterable<ServiceType> serviceTypeIterable(){
        return this.serviceTypeService.serviceTypeIterable();
    }

    public HomeController(IServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping({"/index", "/", ""})
    public ModelAndView index(){
        return new ModelAndView("/index");
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("/login");
    }

    @GetMapping("/layout")
    public ModelAndView template(){
        return new ModelAndView("/layout");
    }

}
