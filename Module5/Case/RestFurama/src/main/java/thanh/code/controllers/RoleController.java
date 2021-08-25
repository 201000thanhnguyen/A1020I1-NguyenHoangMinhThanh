package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Role;
import thanh.code.models.ServiceType;
import thanh.code.service.IRoleService;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@Controller
@RequestMapping("/Role")
public class RoleController {

    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Role>> get() {
        List<Role> roleList = this.roleService.listEntity();
        if (roleList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(roleList, HttpStatus.OK);
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> post() {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> detail(@PathVariable int id) {
        return null;
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<String> update(String string) {
        return null;
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(int id) {
        return null;
    }
}
