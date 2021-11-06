import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IExCustomer} from "../models/ex-customer";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class ExCustomerService {
  private readonly apIExamCustomer = "http://localhost:3000/exCustomer";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAll(): Observable<IExCustomer[]>{
    return this.httpClient.get<IExCustomer[]>(this.apIExamCustomer);
  }

  getOne(id: any): Observable<IExCustomer>{
    return this.httpClient.get<IExCustomer>(this.apIExamCustomer + `/${id}`);
  }

  getLike(field: any): Observable<IExCustomer[]>{
    return this.httpClient.get<IExCustomer[]>(this.apIExamCustomer + `?${field}`);
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
