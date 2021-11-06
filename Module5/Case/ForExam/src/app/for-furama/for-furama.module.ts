import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import {ForFuramaComponent} from "./for-furama.component";
import { CustomerTypeComponent } from './components/customer-type/customer-type.component';
import {FormBuilder, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { CustomerTypeDetailComponent } from './components/customer-type/customer-type-detail/customer-type-detail.component';
import { CustomerTypeEditComponent } from './components/customer-type/customer-type-edit/customer-type-edit.component';
import { CustomerTypeAddComponent } from './components/customer-type/customer-type-add/customer-type-add.component';
import { CustomerComponent } from './components/customer/customer.component';

@NgModule({
  declarations: [
    CustomerTypeComponent,
    CustomerTypeDetailComponent,
    CustomerTypeEditComponent,
    CustomerTypeAddComponent,
    CustomerComponent
  ],
  exports: [
    CustomerTypeComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path: "customer-type", component: CustomerTypeComponent,
        children: [
          {path: "add", component: CustomerTypeAddComponent},
          {path: "detail/:id", component: CustomerTypeDetailComponent},
          {path: "edit/:id", component: CustomerTypeEditComponent}
        ]
      },
      {path: "customer", component: CustomerComponent}
    ]),
    FormsModule
  ]
})
export class ForFuramaModule { }
