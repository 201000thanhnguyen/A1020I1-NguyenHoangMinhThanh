import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {IExamCustomer} from "../models/exam-customer";
import {Observable} from "rxjs";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class ExamCustomerService {
  private readonly apIExamCustomer = "http://localhost:3000/Customer";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAll(): Observable<IExamCustomer[]>{
    return this.httpClient.get<IExamCustomer[]>(this.apIExamCustomer);
  }

  getOne(id: any): Observable<IExamCustomer>{
    return this.httpClient.get<IExamCustomer>(this.apIExamCustomer + `/${id}`);
  }

  getLike(field: any): Observable<IExamCustomer[]>{
    return this.httpClient.get<IExamCustomer[]>(this.apIExamCustomer + `?${field}`);
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
