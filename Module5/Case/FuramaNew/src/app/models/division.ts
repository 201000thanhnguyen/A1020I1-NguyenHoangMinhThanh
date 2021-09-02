export class Division implements IDivision{
  divisionId: number;
  divisionName: string;

  constructor(divisionId: number, divisionName: string) {
    this.divisionId = divisionId;
    this.divisionName = divisionName;
  }
}

export interface IDivision {
  divisionId: number;
  divisionName: string;
}
