import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "./customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private apiCustomer = "http://localhost:8080/api/customer";

  constructor(private httpClient: HttpClient) { }

  getCustomerList(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(`${this.apiCustomer}`);
  }
}
