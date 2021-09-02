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
@RequestMapping("/api/Role")
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
    public ResponseEntity<Role> post(@RequestBody Role role) {
        this.roleService.addOrUpdateEntity(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Role> detail(@PathVariable int id) {
        Role role = this.roleService.findByIdInt(id);
        if (role == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(role, HttpStatus.OK);
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Role> update(@RequestBody Role role) {
        this.roleService.addOrUpdateEntity(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Role> delete(@PathVariable int id) {
        Role role = this.roleService.findByIdInt(id);
        if (role == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.roleService.removeEntity(role);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
