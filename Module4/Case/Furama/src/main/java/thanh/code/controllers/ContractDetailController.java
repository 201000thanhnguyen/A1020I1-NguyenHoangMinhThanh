package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.AttachService;
import thanh.code.models.Contract;
import thanh.code.models.ContractDetail;
import thanh.code.models.ServiceType;
import thanh.code.service.IAttachServiceService;
import thanh.code.service.IContractDetailService;
import thanh.code.service.IContractService;
import thanh.code.service.IServiceTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ContractDetail")
public class ContractDetailController {

    private final IContractDetailService contractDetailService;
    private final IContractService contractService;
    private final IAttachServiceService attachServiceService;
    private final IServiceTypeService serviceTypeService;

    @ModelAttribute("serviceTypeIter")
    public Iterable<ServiceType> serviceTypeIterable(){
        return this.serviceTypeService.serviceTypeIterable();
    }

    @ModelAttribute("contractIter")
    public Iterable<Contract> contractIterable() {
        return this.contractService.contractIterable();
    }

    @ModelAttribute("attachServiceIter")
    public Iterable<AttachService> attachServiceIterable(){
        return this.attachServiceService.attachServiceIterable();
    }

    public ContractDetailController(IContractDetailService contractDetailService, IContractService contractService,
                                    IAttachServiceService attachServiceService, IServiceTypeService serviceTypeService) {
        this.contractDetailService = contractDetailService;
        this.contractService = contractService;
        this.attachServiceService = attachServiceService;
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping({"/index", "/", ""})
    public ModelAndView index() {
        List<ContractDetail> list = this.contractDetailService.listEntity();
        Map<Integer, ContractDetail> listContractDetailNotDuplicate = new HashMap<>();
        for (ContractDetail item : list){
            listContractDetailNotDuplicate.put(item.getContract().getContractId(), item);
        }
        return new ModelAndView("/ContractDetail/index", "listContractDetailNotDuplicate", listContractDetailNotDuplicate);
    }

    @GetMapping("/create/{id}")
    public ModelAndView create(@PathVariable int id){
        ContractDetail contractDetail = new ContractDetail();
        contractDetail.setContract(this.contractService.findByIdInt(id));
        return new ModelAndView("/ContractDetail/create", "contractDetail", contractDetail);
    }

    @GetMapping("/create")
    public ModelAndView createByRequestParam(@RequestParam int id){
        ContractDetail contractDetail = new ContractDetail();
        contractDetail.setContract(this.contractService.findByIdInt(id));
        return new ModelAndView("/ContractDetail/create", "contractDetail", contractDetail);
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/ContractDetail/create");
        }else {
            this.contractDetailService.addOrUpdateEntity(contractDetail);
            return index();
        }
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        return new ModelAndView("/ContractDetail/detail", "listContractDetailOfOnePeople", this.contractDetailService.listContractDetailOfOnePeople(id));
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id){
        ContractDetail contractDetail = this.contractDetailService.findByIdInt(id);
        if (contractDetail == null){
            return index();
        }else {
            return new ModelAndView("/ContractDetail/edit", "contractDetail", contractDetail);
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/ContractDetail/edit");
        }else {
            this.contractDetailService.addOrUpdateEntity(contractDetail);
            return index();
        }
    }

    @GetMapping("/delete/{contractDetailId}/{contractId}")
    public ModelAndView delete(@PathVariable int contractDetailId, @PathVariable int contractId){
        this.contractDetailService.deleteDetailOneRecord(contractDetailId, contractId);
        return index();
    }
}
