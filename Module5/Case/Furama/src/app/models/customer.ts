import {CustomerType, ICustomerType} from "./customer-type";
import {FormGroup, Validators} from "@angular/forms";
import {formBuilderService} from "../services/i-service-base";

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

export var formGroupCustomer: FormGroup = formBuilderService.group(
  {
    customerId: [''],
    customerName: ['', [Validators.required]],
    customerBirthday: [''],
    customerGender: [''],
    customerIdCard: [''],
    customerPhone: [''],
    customerEmail: ['',[Validators.required, Validators.email]],
    customerAddress: [''],
    customerType: ['']
  }
);
