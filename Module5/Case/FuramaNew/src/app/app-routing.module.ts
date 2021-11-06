import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomerTypeComponent} from "./components/customer-type/customer-type.component";
import {CustomerComponent} from "./components/customer/customer.component";
import {CustomerDetailComponent} from "./components/customer/customer-detail/customer-detail.component";
import {AppComponent} from "./app.component";

const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
