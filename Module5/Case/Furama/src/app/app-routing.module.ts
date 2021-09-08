import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ContentComponent} from "./layout/content/content.component";
import {RoomsComponent} from "./rooms/rooms.component";
import {PositionComponent} from "./components/position/position.component";
import {CustomerTypeComponent} from "./components/customer-type/customer-type.component";
import {CustomerComponent} from "./components/customer/customer.component";

const routes: Routes = [
  {path: '', component: ContentComponent},
  {path: 'Position', component: PositionComponent},
  {path: 'CustomerType',component: CustomerTypeComponent},
  {path: 'Customer',component: CustomerComponent},
  {path: 'rooms',component: RoomsComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
