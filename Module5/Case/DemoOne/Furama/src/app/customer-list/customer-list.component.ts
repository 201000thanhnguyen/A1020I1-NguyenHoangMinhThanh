import { Component, OnInit } from '@angular/core';
import {Customer} from "../customer";
import {CustomerService} from "../customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[] | undefined ;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.getCustomers();
  }

  private getCustomers(){
    this.customerService.getCustomerList().subscribe(
      data => {
        this.customers = data;
      }
    )
  }

}
