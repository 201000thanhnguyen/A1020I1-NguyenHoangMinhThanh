import {IEmployee} from "./employee";
import {ICustomer} from "./customer";
import {IService} from "./service";

export class Contract implements IContract{
  contractDeposit: number;
  contractEndDate: string;
  contractId: number;
  contractStartDate: string;
  contractTotalMoney: number;
  customer: ICustomer;
  employee: IEmployee;
  service: IService;


  constructor(contractDeposit: number, contractEndDate: string, contractId: number, contractStartDate: string, contractTotalMoney: number, customer: ICustomer, employee: IEmployee, service: IService) {
    this.contractDeposit = contractDeposit;
    this.contractEndDate = contractEndDate;
    this.contractId = contractId;
    this.contractStartDate = contractStartDate;
    this.contractTotalMoney = contractTotalMoney;
    this.customer = customer;
    this.employee = employee;
    this.service = service;
  }
}

export interface IContract {
  contractId: number;
  contractStartDate: string;
  contractEndDate: string;
  contractDeposit: number;
  contractTotalMoney: number;

  employee: IEmployee;
  customer: ICustomer;
  service: IService;
}
