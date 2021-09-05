import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Position} from "../models/position";
import {FormGroup} from "@angular/forms";
import {baseApiUrl, IServiceBase} from "./i-service-base";

@Injectable({
  providedIn: 'root'
})

export class PositionService implements IServiceBase<Position>{

  private apiUrlPosition = baseApiUrl + "/Position";

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Position[]>{
    return this.httpClient.get<Position[]>(this.apiUrlPosition);
  };

  getOne(id: any): Observable<Position>{
    return this.httpClient.get<Position>(this.apiUrlPosition + `/${id}`);
  }

  addOrUpdate(formGroup: FormGroup): any{
    const id = formGroup.controls.positionId.value;
    if (!id){
      return this.httpClient.post(this.apiUrlPosition, formGroup.value);
    }else {
      return this.httpClient.put(this.apiUrlPosition + `/${id}`, formGroup.value);
    }
  }

  delete(id: any): any{
    return this.httpClient.delete(this.apiUrlPosition + `/${id}`);
  }
}
