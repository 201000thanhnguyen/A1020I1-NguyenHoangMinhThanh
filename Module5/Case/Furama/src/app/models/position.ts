import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {formBuilderService} from "../services/i-service-base";

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

export var formGroupPosition: FormGroup = formBuilderService.group({
  positionId: [''],
  positionName: ['']
});

