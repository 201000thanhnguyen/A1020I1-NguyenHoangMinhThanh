import {ICustomerType} from "./customer-type";

export class Customer implements ICustomer{
  customerAddress: string;
  customerBirthday: string;
  customerEmail: string;
  customerGender: number;
  customerId: number;
  customerIdCard: string;
  customerName: string;
  customerPhone: string;
  customerType: ICustomerType;

  constructor(customerAddress: string, customerBirthday: string, customerEmail: string, customerGender: number,
              customerId: number, customerIdCard: string, customerName: string, customerPhone: string,
              customerType: ICustomerType) {
    this.customerAddress = customerAddress;
    this.customerBirthday = customerBirthday;
    this.customerEmail = customerEmail;
    this.customerGender = customerGender;
    this.customerId = customerId;
    this.customerIdCard = customerIdCard;
    this.customerName = customerName;
    this.customerPhone = customerPhone;
    this.customerType = customerType;
  }
}

export interface ICustomer {
  customerId: number;
  customerName: string;
  customerBirthday: string;
  customerGender: number;
  customerIdCard: string;
  customerPhone: string;
  customerEmail: string;
  customerAddress: string;

  customerType: ICustomerType;
}
