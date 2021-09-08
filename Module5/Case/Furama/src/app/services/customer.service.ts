import { Injectable } from '@angular/core';
import {apiBaseUrl, IServiceBase} from "./i-service-base";
import {Customer} from "../models/customer";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerService implements IServiceBase<Customer>{

  private apiUrlCustomer = apiBaseUrl + "/Customer";

  constructor(private httpClient: HttpClient) { }

  addOrUpdate(formGroup: FormGroup): Observable<Object> {
    const id = formGroup.controls.customerId.value;
    if (!id){
      return this.httpClient.post(this.apiUrlCustomer, formGroup.value);
    }else {
      return this.httpClient.put(this.apiUrlCustomer + `/${id}`, formGroup.value);
    }
  }

  delete(id: any): Observable<Object> {
    return this.httpClient.delete(this.apiUrlCustomer + `/${id}`);
  }

  getAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.apiUrlCustomer);
  }

  getOne(id: any): Observable<Customer> {
    return this.httpClient.get<Customer>(this.apiUrlCustomer + `/${id}`);
  }

}
