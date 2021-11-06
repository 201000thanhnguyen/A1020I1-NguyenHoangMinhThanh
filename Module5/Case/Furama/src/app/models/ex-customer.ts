export class ExCustomer implements IExCustomer{
  id: number;
  name: string;

  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }
}

export interface IExCustomer {
  id: number;
  name: string;
}
