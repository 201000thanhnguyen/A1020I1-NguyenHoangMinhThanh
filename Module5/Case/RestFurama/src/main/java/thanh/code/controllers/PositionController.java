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

@Controller
@RequestMapping("/Position")
public class PositionController {

    private final IPositionService positionService;

    public PositionController(IPositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Position>> get() {
        List<Position> positionList = this.positionService.listEntity();
        if (positionList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(positionList, HttpStatus.OK);
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
