import { Injectable } from '@angular/core';
import {apiBaseUrl, IServiceBase} from "./i-service-base";
import {CustomerType} from "../models/customer-type";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService implements IServiceBase<CustomerType>{

  private apiUrlCustomerType = apiBaseUrl + "/CustomerType";

  constructor(private httpClient: HttpClient) { }

  addOrUpdate(formGroup: FormGroup) {
    const id = formGroup.controls.customerTypeId.value;
    if (!id){
      return this.httpClient.post(this.apiUrlCustomerType, formGroup.value);
    } else {
      return this.httpClient.put(this.apiUrlCustomerType + `/${id}`, formGroup.value);
    }
  }

  delete(id: any) {
    return this.httpClient.delete(this.apiUrlCustomerType + `/${id}`);
  }

  getAll(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(this.apiUrlCustomerType);
  }

  getOne(id: any): Observable<CustomerType> {
    return this.httpClient.get<CustomerType>(this.apiUrlCustomerType + `/${id}`);
  }

}
