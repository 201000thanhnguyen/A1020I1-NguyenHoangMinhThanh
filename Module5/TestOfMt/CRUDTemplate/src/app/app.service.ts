import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormGroup} from '@angular/forms';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  private apiCustomer = 'http://localhost:8080/api/customer';
  constructor(private httpClient: HttpClient) { }
  // tslint:disable-next-line:typedef
  addOrUpdateCustomerService(formGroup: FormGroup) {
    const customerId = formGroup.controls.id.value;
    if (!customerId){
      return this.httpClient.post(this.apiCustomer, formGroup.value);
    }else {
      return this.httpClient.put(this.apiCustomer + `/${customerId}`, formGroup.value);
    }
  }

  // tslint:disable-next-line:typedef
  deleteCustomerService(customerId: number){
    return this.httpClient.delete(this.apiCustomer + `/${customerId}`);
  }

  // tslint:disable-next-line:typedef
  getCustomerService(id: number): Observable<any> {
    return this.httpClient.get<any>(this.apiCustomer + `/${id}`);
  }

  getCustomerListService(): Observable<any[]>{
    return this.httpClient.get<any[]>(`${this.apiCustomer}`);
  }
}
