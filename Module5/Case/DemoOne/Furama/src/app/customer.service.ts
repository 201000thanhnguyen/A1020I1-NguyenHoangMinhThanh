import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "./customer";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private apiCustomer = "http://localhost:8080/api/customer";

  constructor(private httpClient: HttpClient) { }

  addOrUpdateCustomerService(formGroup: FormGroup) {
    const customerId = formGroup.controls.id.value;
    if (!customerId){
      return this.httpClient.post(this.apiCustomer, formGroup.value);
    }else {
      return this.httpClient.put(this.apiCustomer + `/${customerId}`, formGroup.value);
    }
  }

  deleteCustomerService(id: number){
    return this.httpClient.delete(this.apiCustomer + `/${id}`);
  }

  getCustomerService(id: any): Observable<any> {
    return this.httpClient.get<any>(this.apiCustomer + `/${id}`);
  }

  getCustomerListService(): Observable<any[]>{
    return this.httpClient.get<any[]>(`${this.apiCustomer}`);
  }
}
