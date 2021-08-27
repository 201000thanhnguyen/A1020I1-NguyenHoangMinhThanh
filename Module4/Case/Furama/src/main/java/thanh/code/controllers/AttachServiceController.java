package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.AttachService;
import thanh.code.models.ServiceType;
import thanh.code.service.IAttachServiceService;
import thanh.code.service.IServiceService;
import thanh.code.service.IServiceTypeService;

@Controller
@RequestMapping("/AttachService")
public class AttachServiceController {

    private final IAttachServiceService attachServiceService;
    private final IServiceTypeService serviceTypeService;

    @ModelAttribute("serviceTypeIter")
    public Iterable<ServiceType> serviceTypeIterable(){
        return this.serviceTypeService.serviceTypeIterable();
    }

    public AttachServiceController(IAttachServiceService attachServiceService, IServiceTypeService serviceTypeService) {
        this.attachServiceService = attachServiceService;
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping({"/index", "/", ""})
    public ModelAndView index() {
        return new ModelAndView("/AttachService/index", "listAttachService", this.attachServiceService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/AttachService/create", "attachService", new AttachService());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute AttachService attachService, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/AttachService/create");
        } else {
            this.attachServiceService.addOrUpdateEntity(attachService);
            return index();
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        AttachService attachService = this.attachServiceService.findByIdInt(id);
        if (attachService == null) {
            return index();
        } else {
            return new ModelAndView("/AttachService/edit", "attachService", attachService);
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute AttachService attachService, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/AttachService/edit");
        } else {
            this.attachServiceService.addOrUpdateEntity(attachService);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        this.attachServiceService.removeEntity(this.attachServiceService.findByIdInt(id));
        return index();
    }
}
