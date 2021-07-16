package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Division;
import thanh.code.models.EducationDegree;
import thanh.code.models.Employee;
import thanh.code.models.Position;
import thanh.code.service.IDivisionService;
import thanh.code.service.IEducationDegreeService;
import thanh.code.service.IEmployeeService;
import thanh.code.service.IPositionService;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {

    final IEmployeeService employeeService;
    // for tag select option client
    final IDivisionService divisionService;
    final IPositionService positionService;
    final IEducationDegreeService educationDegreeService;

    @ModelAttribute("divisionIter")
    public Iterable<Division> divisionIterable(){
        return divisionService.divisionIterable();
    }

    @ModelAttribute("positionIter")
    public Iterable<Position> positionIterable(){
        return positionService.positionIterable();
    }

    @ModelAttribute("educationDegreeIter")
    public Iterable<EducationDegree> educationDegreeIterable(){
        return educationDegreeService.educationDegreeIterable();
    }
    // for tag select option client

    public EmployeeController(IEmployeeService employeeService, IDivisionService divisionService,
                              IPositionService positionService, IEducationDegreeService educationDegreeService) {
        this.employeeService = employeeService;
        this.divisionService = divisionService;
        this.positionService = positionService;
        this.educationDegreeService = educationDegreeService;
    }

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("/Employee/index", "listEmployee", this.employeeService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/Employee/create", "employee", new Employee());
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute Employee employee,BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Employee/create");
        }else {
            this.employeeService.addOrUpdateEntity(employee);
            return index();
        }
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        return new ModelAndView("/Employee/detail", "employee", this.employeeService.findByIdInt(id));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/Employee/edit", "employee", this.employeeService.findByIdInt(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute Employee employee, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/Employee/edit");
        }else {
            this.employeeService.addOrUpdateEntity(employee);
            return index();
        }
    }
}
