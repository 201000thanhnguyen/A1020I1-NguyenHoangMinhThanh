import {ICustomerType} from "./customer-type";
export class Customer implements ICustomer{
  address: string;
  birthday: string;
  email: string;
  gender: number;
  id: number;
  name: string;
  customerType: ICustomerType;


  constructor(address: string, birthday: string, email: string, gender: number, customerId: number, name: string, customerType: ICustomerType) {
    this.address = address;
    this.birthday = birthday;
    this.email = email;
    this.gender = gender;
    this.id = customerId;
    this.name = name;
    this.customerType = customerType;
  }
}

export interface ICustomer {
  id: number;
  name: string;
  birthday: string;
  gender: number;
  email: string;
  address: string;

  customerType: ICustomerType;
}
