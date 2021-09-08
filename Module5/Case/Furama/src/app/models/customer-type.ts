import {FormGroup, Validators} from "@angular/forms";
import {formBuilderService} from "../services/i-service-base";

export class CustomerType implements ICustomerType{
  customerTypeId: number;
  customerTypeName: string;

  constructor(customerTypeId: number, customerTypeName: string) {
    this.customerTypeId = customerTypeId;
    this.customerTypeName = customerTypeName;
  }
}

export interface ICustomerType {
  customerTypeId: number;
  customerTypeName: string;
}

export var formGroupCustomerType: FormGroup = formBuilderService.group({
  customerTypeId: [''],
  customerTypeName: ['', [Validators.required]]
});
