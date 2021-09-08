package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanh.code.models.User;
import thanh.code.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> get() {
        List<User> roleList = this.userService.listEntity();
        if (roleList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(roleList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<User> post(@RequestBody User user) {
        this.userService.addOrUpdateEntity(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> detail(@PathVariable int id) {
        User user = this.userService.findByIdInt(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user) {
        if (this.userService.findByIdString(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.userService.addOrUpdateEntity(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable String id) {
        User user = this.userService.findByIdString(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.userService.removeEntity(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
