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
