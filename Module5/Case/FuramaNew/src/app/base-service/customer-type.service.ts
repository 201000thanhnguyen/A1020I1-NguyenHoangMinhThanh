import { Injectable } from '@angular/core';
import {apiBaseService, IBaseService} from "./base-service.module";
import {ICustomerType} from "../models/customer-type";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService implements IBaseService<ICustomerType>{

  private readonly apiCustomerType: string = apiBaseService + "/CustomerType";

  constructor(private httpClient: HttpClient) {
  }

  addOrUpdate(formGroup: FormGroup): Observable<Object> {
    const id = formGroup.controls.id.value;
    if (!id){
      return this.httpClient.post(this.apiCustomerType, formGroup.value);
    }else {
      return this.httpClient.put(this.apiCustomerType + `/${id}`, formGroup.value);
    }
  }

  delete(id: any): Observable<Object> {
    return this.httpClient.delete(this.apiCustomerType + `/${id}`);
  }

  getAll(): Observable<ICustomerType[]> {
    return this.httpClient.get<ICustomerType[]>(this.apiCustomerType);
  }

  getOne(id: any): Observable<ICustomerType> {
    return this.httpClient.get<ICustomerType>(this.apiCustomerType + `/${id}`);
  }

}
