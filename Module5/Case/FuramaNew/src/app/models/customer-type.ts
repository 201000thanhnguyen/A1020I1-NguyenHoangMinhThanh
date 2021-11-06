import {FormGroup, Validators} from "@angular/forms";
import {formBuilder} from "./models.module";

export class CustomerType implements ICustomerType{
  id: number;
  customerTypeName: string;

  constructor(customerTypeId: number, customerTypeName: string) {
    this.id = customerTypeId;
    this.customerTypeName = customerTypeName;
  }
}

export interface ICustomerType {
  id: number;
  customerTypeName: string;
}

export var formGroupCustomerType: FormGroup = formBuilder.group({
  id: [''],
  customerTypeName: ['', [Validators.required]]
});
