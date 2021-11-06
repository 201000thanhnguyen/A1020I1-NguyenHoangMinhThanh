import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CustomerType} from "../models/customer-type";
import {FormGroup} from "@angular/forms";
@Injectable({
  providedIn: 'root'
})

export class CustomerTypeService {

  private readonly apiCustomerType = "http://localhost:3000/CustomerType";

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<CustomerType[]>{
    return this.httpClient.get<CustomerType[]>(this.apiCustomerType);
  }

  getOne(id: any): Observable<CustomerType>{
    return this.httpClient.get<CustomerType>(this.apiCustomerType + `/${id}`);
  }

  getLike(field: any):  Observable<CustomerType[]>{
    return this.httpClient.get<CustomerType[]>(this.apiCustomerType + `?${field}`);
  }

  addOrUpdate(formGroup: FormGroup): Observable<Object>{
    const id = formGroup.controls.id.value;
    if (!id){
      return this.httpClient.post(this.apiCustomerType, formGroup.value);
    }else {
      return this.httpClient.put(this.apiCustomerType + `/${id}`, formGroup.value);
    }
  }

  delete(id: any): Observable<Object>{
    return this.httpClient.delete(this.apiCustomerType + `/${id}`);
  }

}
