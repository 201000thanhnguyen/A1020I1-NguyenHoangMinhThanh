package thanh.code.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.People;
import thanh.code.service.IPeopleService;

@Controller
@RequestMapping("/People")
public class PeopleController {
    final IPeopleService _peopleService;

    public PeopleController(IPeopleService peopleService) {
        _peopleService = peopleService;
    }

    @GetMapping("/index")
    public ModelAndView index(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("/People/index", "listPeople", this._peopleService.listLimitEntity(pageable));
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/People/create", "people", new People());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute People people, BindingResult bindingResult, @PageableDefault(value = 2) Pageable pageable){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/People/create");
        }else {
            this._peopleService.addOrUpdateEntity(people);
            return index(pageable);
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id, @PageableDefault(value = 2) Pageable pageable){
        this._peopleService.removeEntity(this._peopleService.detailEntityById(id));
        return index(pageable);
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        return new ModelAndView("/People/detail", "people", this._peopleService.detailEntityById(id));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/People/edit", "people", this._peopleService.detailEntityById(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute People people, @PageableDefault(value = 2) Pageable pageable){
        this._peopleService.addOrUpdateEntity(people);
        return index(pageable);
    }
}
