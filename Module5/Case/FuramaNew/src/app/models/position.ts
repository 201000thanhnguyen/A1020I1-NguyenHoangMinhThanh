export class Position implements IPosition{
  positionId: number;
  positionName: string;

  constructor(positionId: number, positionName: string) {
    this.positionId = positionId;
    this.positionName = positionName;
  }
}

export interface IPosition {
  positionId: number;
  positionName: string;
}
