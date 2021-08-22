package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Role;
import thanh.code.models.ServiceType;
import thanh.code.service.IRoleService;
import thanh.code.service.IServiceTypeService;

@Controller
@RequestMapping("/Role")
public class RoleController {

    final IRoleService roleService;
    private final IServiceTypeService serviceTypeService;

    @ModelAttribute("serviceTypeIter")
    public Iterable<ServiceType> serviceTypeIterable(){
        return this.serviceTypeService.serviceTypeIterable();
    }

    public RoleController(IRoleService roleService, IServiceTypeService serviceTypeService) {
        this.roleService = roleService;
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping({"/index", "/", ""})
    public ModelAndView index(){
        return new ModelAndView("/Role/index", "listRole", this.roleService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/Role/create", "role", new Role());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/Role/edit", "role", this.roleService.findByIdInt(id));
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute Role role, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Role/create");
        }else {
            this.roleService.addOrUpdateEntity(role);
            return index();
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute Role role, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Role/edit");
        }else {
            this.roleService.addOrUpdateEntity(role);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        this.roleService.removeEntity(this.roleService.findByIdInt(id));
        return index();
    }
}