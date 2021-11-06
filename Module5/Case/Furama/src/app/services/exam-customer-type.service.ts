import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IExamCustomerType} from "../models/exam-customer-type";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class ExamCustomerTypeService {
  private readonly apiIExamCustomerType = "http://localhost:3000/CustomerType";

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<IExamCustomerType[]>{
    return this.httpClient.get<IExamCustomerType[]>(this.apiIExamCustomerType);
  }

  getOne(id: any): Observable<IExamCustomerType>{
    return this.httpClient.get<IExamCustomerType>(this.apiIExamCustomerType + `/${id}`);
  }

  getLike(field: any):  Observable<IExamCustomerType[]>{
    return this.httpClient.get<IExamCustomerType[]>(this.apiIExamCustomerType + `?${field}`);
  }

  addOrUpdate(formGroup: FormGroup): Observable<Object>{
    const id = formGroup.controls.id.value;
    if (!id){
      return this.httpClient.post(this.apiIExamCustomerType, formGroup.value);
    }else {
      return this.httpClient.put(this.apiIExamCustomerType + `/${id}`, formGroup.value);
    }
  }

  delete(id: any): Observable<Object>{
    return this.httpClient.delete(this.apiIExamCustomerType + `/${id}`);
  }
}
