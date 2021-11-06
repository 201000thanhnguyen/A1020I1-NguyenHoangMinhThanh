import {IExamCustomerType} from "./exam-customer-type";

export class ExamCustomer implements IExamCustomer{
  address: string;
  birthday: string;
  email: string;
  gender: number;
  id: number;
  name: string;
  customerType: IExamCustomerType;


  constructor(address: string, birthday: string, email: string, gender: number, customerId: number, name: string, customerType: IExamCustomerType) {
    this.address = address;
    this.birthday = birthday;
    this.email = email;
    this.gender = gender;
    this.id = customerId;
    this.name = name;
    this.customerType = customerType;
  }
}

export interface IExamCustomer {
  id: number;
  name: string;
  birthday: string;
  gender: number;
  email: string;
  address: string;

  customerType: IExamCustomerType;
}
