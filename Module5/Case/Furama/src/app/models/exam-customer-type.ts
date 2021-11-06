
export class ExamCustomerType implements IExamCustomerType{
  id: number;
  name: string;

  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }
}

export interface IExamCustomerType {
  id: number;
  name: string;
}
