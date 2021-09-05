package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Position;
import thanh.code.models.ServiceType;
import thanh.code.service.IPositionService;
import thanh.code.service.IServiceTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/Position")
public class PositionController {

    private final IPositionService positionService;

    public PositionController(IPositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public ResponseEntity<List<Position>> get() {
        List<Position> positionList = this.positionService.listEntity();
        if (positionList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(positionList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Position> post(@RequestBody Position position) {
        this.positionService.addOrUpdateEntity(position);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> detail(@PathVariable int id) {
        Position position = this.positionService.findByIdInt(id);
        if (position == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(position, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Position> update(@PathVariable int id, @RequestBody Position position) {
        Position position1 = this.positionService.findByIdInt(id);
        if (position1 == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.positionService.addOrUpdateEntity(position);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Position> delete(@PathVariable int id) {
        Position position = this.positionService.findByIdInt(id);
        if (position == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            this.positionService.removeEntity(position);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
