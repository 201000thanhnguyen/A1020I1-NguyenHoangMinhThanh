package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.service.IPeopleService;

@Controller
@RequestMapping(value = "/People")
public class PeopleController {
    final IPeopleService _peopleService;

    public PeopleController(IPeopleService peopleService){
        _peopleService = peopleService;
    }

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/People/index");
        modelAndView.addObject("listPeople", this._peopleService.listPeople());
        return modelAndView;
    }
}
