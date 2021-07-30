package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thanh.code.models.Phone;
import thanh.code.service.IPhoneService;

import java.util.List;

@RestController
@RequestMapping("/api/phone")
public class PhoneController {

    final IPhoneService phoneService;

    public PhoneController(IPhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public ResponseEntity<List<Phone>> get(){
        List<Phone> phoneList = this.phoneService.listEntity();
        if (phoneList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(phoneList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> get(@PathVariable int id){
        Phone phone = this.phoneService.findByIdInt(id);
        if(phone == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(phone, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Phone> post(@RequestBody Phone phone){
        this.phoneService.addOrUpdateEntity(phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> delete(@PathVariable int id){
        Phone phone = this.phoneService.findByIdInt(id);
        if (phone == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.phoneService.removeEntity(phone);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<Phone> put(@RequestBody Phone phone){
        Phone phoneUpdate = this.phoneService.findByIdInt(phone.getPhoneId());
        if (phoneUpdate == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.phoneService.addOrUpdateEntity(phone);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
