import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICustomer} from "../models/customer";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private readonly apiCustomer = "http://localhost:3000/Customer";

  constructor(
    private httpClient: HttpClient
  ) { }

  getAll(): Observable<ICustomer[]>{
    return this.httpClient.get<ICustomer[]>(this.apiCustomer);
  }

  getOne(id: any): Observable<ICustomer>{
    return this.httpClient.get<ICustomer>(this.apiCustomer + `/${id}`);
  }

  getLike(field: any): Observable<ICustomer[]>{
    return this.httpClient.get<ICustomer[]>(this.apiCustomer + `?${field}`);
  }

  addOrUpdate(formGroup: FormGroup): Observable<Object>{
    const id = formGroup.controls.id.value;
    if (!id){
      return this.httpClient.post(this.apiCustomer, formGroup.value);
    }else {
      return this.httpClient.put(this.apiCustomer + `/${id}`, formGroup.value);
    }
  }

  delete(id: any): Observable<Object>{
    return this.httpClient.delete(this.apiCustomer + `/${id}`);
  }
}
