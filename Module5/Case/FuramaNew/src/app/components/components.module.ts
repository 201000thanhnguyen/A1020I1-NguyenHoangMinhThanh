import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerTypeComponent } from './customer-type/customer-type.component';
import {DataTablesModule} from "angular-datatables";
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { CustomerComponent } from './customer/customer.component';
import { CustomerDetailComponent } from './customer/customer-detail/customer-detail.component';
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [
    CustomerTypeComponent,
    CustomerComponent,
    CustomerDetailComponent,
  ],
  exports: [],
  imports: [
    CommonModule,
    HttpClientModule,
    DataTablesModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    RouterModule.forRoot([
      {path: "CustomerType", component: CustomerTypeComponent},
      {path: "Customer/detail/:id", component: CustomerDetailComponent},
      {path: "Customer", component: CustomerComponent,
        children: [
          {path: "detail", component: CustomerDetailComponent},
        ]
      }
    ])
  ]
})
export class ComponentsModule { }
