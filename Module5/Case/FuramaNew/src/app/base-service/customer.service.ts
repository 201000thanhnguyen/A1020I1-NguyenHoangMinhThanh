import { Injectable } from '@angular/core';
import {apiBaseService, IBaseService} from "./base-service.module";
import {Customer, ICustomer} from "../models/customer";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerService implements IBaseService<ICustomer>{

  private readonly apiCustomer = apiBaseService + "/Customer";

  constructor(private httpClient: HttpClient) {
  }

  addOrUpdate(formGroup: FormGroup): Observable<Object> {
    const id = formGroup.controls.id.value;
    if (!id){
      return this.httpClient.post(this.apiCustomer, formGroup.value);
    }else {
      return this.httpClient.put(this.apiCustomer + `/${id}`, formGroup.value);
    }
  }

  delete(id: any): Observable<Object> {
    return this.httpClient.delete(this.apiCustomer + `/${id}`);
  }

  getAll(): Observable<ICustomer[]> {
    return this.httpClient.get<ICustomer[]>(this.apiCustomer);
  }

  getOne(id: any): Observable<ICustomer> {
    return this.httpClient.get<ICustomer>(this.apiCustomer + `/${id}`);
  }


}
