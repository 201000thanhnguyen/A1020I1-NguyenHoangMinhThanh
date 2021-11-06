package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.*;
import thanh.code.service.*;

import java.util.List;

@RestController
@RequestMapping("/api/Contract")
public class ContractController {

    private final IContractService contractService;

    public ContractController(IContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public ResponseEntity<List<Contract>> get() {
        List<Contract> contractList = this.contractService.listEntity();
        if (contractList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contractList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Contract> post(@RequestBody Contract contract) {
        this.contractService.addOrUpdateEntity(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> detail(@PathVariable int id) {
        Contract contract = this.contractService.findByIdInt(id);
        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contract, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contract> update(@PathVariable int id, @RequestBody Contract contract) {
        if (this.contractService.findByIdInt(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.contractService.addOrUpdateEntity(contract);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contract> delete(@PathVariable int id) {
        Contract contract = this.contractService.findByIdInt(id);
        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.contractService.removeEntity(contract);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
