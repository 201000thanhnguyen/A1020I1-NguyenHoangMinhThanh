package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.AttachService;
import thanh.code.models.ServiceType;
import thanh.code.service.IAttachServiceService;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/AttachService")
public class AttachServiceController {

    private final IAttachServiceService attachServiceService;

    public AttachServiceController(IAttachServiceService attachServiceService) {
        this.attachServiceService = attachServiceService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<AttachService>> get() {
        List<AttachService> attachServiceList = this.attachServiceService.listEntity();
        if (attachServiceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(attachServiceList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<AttachService> post(@RequestBody AttachService attachService) {
        this.attachServiceService.addOrUpdateEntity(attachService);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AttachService> detail(@PathVariable int id) {
        AttachService attachService = this.attachServiceService.findByIdInt(id);
        if (attachService == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(attachService, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<AttachService> update(@RequestBody AttachService attachService){
        if (attachService == null
                || this.attachServiceService.findByIdInt(attachService.getAttachServiceId()) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.attachServiceService.addOrUpdateEntity(attachService);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AttachService> delete(@PathVariable int id) {
        if (this.attachServiceService.findByIdInt(id) == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            this.attachServiceService.removeEntity(this.attachServiceService.findByIdInt(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    
}
