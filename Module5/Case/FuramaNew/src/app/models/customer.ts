import {ICustomerType} from "./customer-type";
import {FormGroup, Validators} from "@angular/forms";
import {formBuilder} from "./models.module";

export class Customer implements ICustomer{
  customerAddress: string;
  customerBirthday: string;
  customerEmail: string;
  customerGender: number;
  id: number;
  customerName: string;
  customerType: ICustomerType;


  constructor(customerAddress: string, customerBirthday: string, customerEmail: string, customerGender: number, customerId: number, customerName: string, customerType: ICustomerType) {
    this.customerAddress = customerAddress;
    this.customerBirthday = customerBirthday;
    this.customerEmail = customerEmail;
    this.customerGender = customerGender;
    this.id = customerId;
    this.customerName = customerName;
    this.customerType = customerType;
  }
}

export interface ICustomer {
  id: number;
  customerName: string;
  customerBirthday: string;
  customerGender: number;
  customerEmail: string;
  customerAddress: string;

  customerType: ICustomerType;
}

export var formGroupCustomer: FormGroup = formBuilder.group(
  {
    id: [''],
    customerName: ['', [Validators.required]],
    customerBirthday: ['', [Validators.required]],
    customerGender: ['', [Validators.required]],
    customerEmail: ['',[Validators.required, Validators.email]],
    customerAddress: ['', [Validators.required]],
    customerType: ['', [Validators.required]]
  }
);
