import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {Customer} from "../../model/customer";

@Component({
  selector: 'app-customer-controller',
  templateUrl: './customer-controller.component.html',
  styleUrls: ['./customer-controller.component.css']
})
export class CustomerControllerComponent implements OnInit {

  customers: Customer[] | undefined;

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.getCustomerList();
  }

  private getCustomerList(){
    this.customerService.getCustomerList().subscribe(data => {this.customers = data;})
  }

}
