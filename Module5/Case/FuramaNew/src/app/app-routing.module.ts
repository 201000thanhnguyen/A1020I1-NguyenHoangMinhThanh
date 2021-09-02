import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AttachServiceComponent } from './Components/attach-service/attach-service.component';
import { ContractComponent } from './Components/contract/contract.component';
import { ContractDetailComponent } from './Components/contract-detail/contract-detail.component';
import { CustomerComponent } from './Components/customer/customer.component';
import { CustomerTypeComponent } from './Components/customer-type/customer-type.component';
import { DivisionComponent } from './Components/division/division.component';
import { EducationDegreeComponent } from './Components/education-degree/education-degree.component';
import { PositionComponent } from './Components/position/position.component';
import { RentTypeComponent } from './Components/rent-type/rent-type.component';
import { RoleComponent } from './Components/role/role.component';
import { ServiceComponent } from './Components/service/service.component';
import { ServiceTypeComponent } from './Components/service-type/service-type.component';
import {AppComponent} from "./app.component";
import {EmployeeComponent} from "./Components/employee/employee.component";

const routes: Routes = [
  {path: '', component: EmployeeComponent},
  {path: 'employee', component: EmployeeComponent},
  {path: 'attach-service', component: AttachServiceComponent, children: [
      {path: ':id', component: AttachServiceComponent}
    ]},
  {path: 'contract', component: ContractComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
