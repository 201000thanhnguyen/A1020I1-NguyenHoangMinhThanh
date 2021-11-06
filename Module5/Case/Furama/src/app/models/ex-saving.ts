import {IExCustomer} from "./ex-customer";

export class ExSaving implements IExSaving{
  dateOpenSaving: string;
  exCustomer: IExCustomer;
  id: number;
  incentives: string;
  interest: string;
  money: number;
  term: string;
  timeSaving: string;


  constructor(dateOpenSaving: string, exCustomer: IExCustomer, id: number, incentives: string, interest: string, money: number, term: string, timeSaving: string) {
    this.dateOpenSaving = dateOpenSaving;
    this.exCustomer = exCustomer;
    this.id = id;
    this.incentives = incentives;
    this.interest = interest;
    this.money = money;
    this.term = term;
    this.timeSaving = timeSaving;
  }
}

export interface IExSaving {
  id: number;
  exCustomer: IExCustomer;
  dateOpenSaving: string;
  timeSaving: string;
  term: string;
  money: number;
  interest: string;
  incentives: string;
}
