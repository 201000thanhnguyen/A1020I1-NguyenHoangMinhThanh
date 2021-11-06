
export class CustomerType implements ICustomerType{
  id: number;
  name: string;

  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }
}

export interface ICustomerType {
  id: number;
  name: string;
}
