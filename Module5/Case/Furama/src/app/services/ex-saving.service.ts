import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IExSaving} from "../models/ex-saving";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class ExSavingService {
  private readonly apIExamCustomer = "http://localhost:3000/exSaving";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAll(): Observable<IExSaving[]>{
    return this.httpClient.get<IExSaving[]>(this.apIExamCustomer);
  }

  getOne(id: any): Observable<IExSaving>{
    return this.httpClient.get<IExSaving>(this.apIExamCustomer + `/${id}`);
  }

  getLike(field: any): Observable<IExSaving[]>{
    return this.httpClient.get<IExSaving[]>(this.apIExamCustomer + `?${field}`);
  }

  addOrUpdate(formGroup: FormGroup): Observable<Object>{
    const id = formGroup.controls.id.value;
    if (!id){
      return this.httpClient.post(this.apIExamCustomer, formGroup.value);
    }else {
      return this.httpClient.put(this.apIExamCustomer + `/${id}`, formGroup.value);
    }
  }

  delete(id: any): Observable<Object>{
    return this.httpClient.delete(this.apIExamCustomer + `/${id}`);
  }
}
