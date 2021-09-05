import {IAttachService} from "./attach-service";
import {IContract} from "./contract";

export class ContractDetail implements IContractDetail{
  attachService: IAttachService;
  contract: IContract;
  contractDetailId: number;
  contractDetailQuantity: number;


  constructor(attachService: IAttachService, contract: IContract, contractDetailId: number, contractDetailQuantity: number) {
    this.attachService = attachService;
    this.contract = contract;
    this.contractDetailId = contractDetailId;
    this.contractDetailQuantity = contractDetailQuantity;
  }
}

export interface IContractDetail {
  contractDetailId: number;
  contractDetailQuantity: number;

  attachService: IAttachService;
  contract: IContract;
}
