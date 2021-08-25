import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer";
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private apiCustomer = "http://localhost:8080/RestFurama/api/customer";
  constructor(private httpClient: HttpClient) { }

  getCustomerList(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(`${this.apiCustomer}`);
  }
}
