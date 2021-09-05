package thanh.code.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import thanh.code.models.ContractDetail;
import thanh.code.service.IContractDetailService;

import java.util.List;

@RestController
@RequestMapping("/api/ContractDetail")
public class ContractDetailController {

    private final IContractDetailService contractDetailService;

    public ContractDetailController(IContractDetailService contractDetailService) {
        this.contractDetailService = contractDetailService;
    }

    @GetMapping
    public ResponseEntity<List<ContractDetail>> get() {
        List<ContractDetail> contractDetailList = this.contractDetailService.listEntity();
        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<ContractDetail> post(@RequestBody ContractDetail contractDetail) {
        this.contractDetailService.addOrUpdateEntity(contractDetail);
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractDetail> detail(@PathVariable int id) {
        ContractDetail contractDetail = this.contractDetailService.findByIdInt(id);
        if (contractDetail == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contractDetail, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractDetail> update(@PathVariable int id, @RequestBody ContractDetail contractDetail) {
        if (this.contractDetailService.findByIdInt(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.contractDetailService.addOrUpdateEntity(contractDetail);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContractDetail> delete(@PathVariable int id) {
        ContractDetail contractDetail = this.contractDetailService.findByIdInt(id);
        if (contractDetail == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            this.contractDetailService.removeEntity(contractDetail);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
