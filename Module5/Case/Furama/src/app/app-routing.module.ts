import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ContentComponent} from "./layout/content/content.component";
import {RoomsComponent} from "./rooms/rooms.component";
import {PositionComponent} from "./components/position/position.component";
import {CustomerTypeComponent} from "./components/customer-type/customer-type.component";
import {CustomerComponent} from "./components/customer/customer.component";
import {ExamCustomerComponent} from "./components/exam-customer/exam-customer.component";
import {ExSavingComponent} from "./components/ex-saving/ex-saving.component";
import {ExCustomerComponent} from "./components/ex-customer/ex-customer.component";

const routes: Routes = [
  {path: '', component: ContentComponent},
  {path: 'Position', component: PositionComponent},
  {path: 'CustomerType',component: CustomerTypeComponent},
  {path: 'Customer',component: CustomerComponent},
  {path: 'exam-customer',component: ExamCustomerComponent},
  {path: 'ex-saving',component: ExSavingComponent},
  {path: 'ex-customer',component: ExCustomerComponent},
  {path: 'rooms',component: RoomsComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
