import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DataTablesModule} from "angular-datatables";
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
import {EmployeeComponent} from "./Components/employee/employee.component";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {NgbPaginationModule, NgbAlertModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    AttachServiceComponent,
    ContractComponent,
    ContractDetailComponent,
    CustomerComponent,
    CustomerTypeComponent,
    DivisionComponent,
    EducationDegreeComponent,
    PositionComponent,
    RentTypeComponent,
    RoleComponent,
    ServiceComponent,
    ServiceTypeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    DataTablesModule,
    NgbModule,
    NgbPaginationModule,
    NgbAlertModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
