export class RentType implements IRentType{
  rentTypeCost: number;
  rentTypeId: number;
  rentTypeName: string;

  constructor(rentTypeCost: number, rentTypeId: number, rentTypeName: string) {
    this.rentTypeCost = rentTypeCost;
    this.rentTypeId = rentTypeId;
    this.rentTypeName = rentTypeName;
  }
}

export interface IRentType {
  rentTypeId: number;
  rentTypeName: string;
  rentTypeCost: number;
}
