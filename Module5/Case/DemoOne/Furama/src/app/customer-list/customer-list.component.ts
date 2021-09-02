import { Component, OnInit } from '@angular/core';
import {Customer} from "../customer";
import {CustomerService} from "../customer.service";
import {FormBuilder, FormGroup} from "@angular/forms";

import * as $ from 'jquery';
@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  formGroup!: FormGroup;
  customers: Customer[] = [] ;

  attributeReadonly: boolean = false;
  attributeHidden: boolean = false;

  constructor(
    private customerService: CustomerService,
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      id: '',
      firstName: '',
      lastName: ''
    });

    this.getCustomerList();
  }

  getCustomerList(){
    this.customerService.getCustomerListService().subscribe(
      (data) => {
        this.customers = data;
      },
    );
  }

  getCustomer(customerId: number){
    this.inverseValueReadonly();
    this.customerService.getCustomerService(customerId).subscribe((data) => {
      Object.keys(this.formGroup.controls).forEach( key => {
        this.formGroup.controls[key].setValue(data[key]);
      })
    });
  }

  addOrUpdateCustomer(){
    this.customerService.addOrUpdateCustomerService(this.formGroup).subscribe(() => { this.reset() });
  }

  deleteCustomer(id: number){
    this.customerService.deleteCustomerService(id).subscribe(() => { this.reset() });
  }

  reset(){
    this.formGroup.reset();
    this.getCustomerList();
  }

  buttonAddCustomer(){
    this.formGroup.reset();
    this.inverseValueReadonly();
  }

  buttonDeleteCustomer(id: number){
    this.getCustomer(id);
    this.attributeReadonly = true;
    this.attributeHidden = true;
  }

  inverseValueReadonly(){
    if (this.attributeReadonly){
      this.attributeReadonly = false;
      this.attributeHidden = false;
    }
  }

  closeModal(idModal: any){
    // @ts-ignore
    window.$('#'+idModal).modal('hide');
  }
}
