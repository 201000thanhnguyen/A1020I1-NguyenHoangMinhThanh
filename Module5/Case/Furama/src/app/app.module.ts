import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './layout/header/header.component';
import { FooterComponent } from './layout/footer/footer.component';
import { SubHeaderComponent } from './layout/sub-header/sub-header.component';
import { ContentComponent } from './layout/content/content.component';
import {RoomsComponent} from "./rooms/rooms.component";
import {EmployeeComponent} from "./components/employee/employee.component";
import {AttachServiceComponent} from "./components/attach-service/attach-service.component";
import {ContractComponent} from "./components/contract/contract.component";
import {ContractDetailComponent} from "./components/contract-detail/contract-detail.component";
import {CustomerComponent} from "./components/customer/customer.component";
import {CustomerTypeComponent} from "./components/customer-type/customer-type.component";
import {DivisionComponent} from "./components/division/division.component";
import {EducationDegreeComponent} from "./components/education-degree/education-degree.component";
import {PositionComponent} from "./components/position/position.component";
import {RentTypeComponent} from "./components/rent-type/rent-type.component";
import {RoleComponent} from "./components/role/role.component";
import {ServiceComponent} from "./components/service/service.component";
import {ServiceTypeComponent} from "./components/service-type/service-type.component";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {DataTablesModule} from 'angular-datatables';
import { ExamCustomerComponent } from './components/exam-customer/exam-customer.component';
import { ExSavingComponent } from './components/ex-saving/ex-saving.component';
import { ExCustomerComponent } from './components/ex-customer/ex-customer.component';

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
    HeaderComponent,
    FooterComponent,
    SubHeaderComponent,
    ContentComponent,
    RoomsComponent,
    ExamCustomerComponent,
    ExSavingComponent,
    ExCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    DataTablesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
