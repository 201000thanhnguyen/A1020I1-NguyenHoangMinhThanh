import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import {DataTablesModule} from "angular-datatables";
import {ComponentsModule} from "./components/components.module";
import {ModelsModule} from "./models/models.module";
import {BaseServiceModule} from "./base-service/base-service.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    DataTablesModule,
    BrowserAnimationsModule,
    ComponentsModule,
    ModelsModule,
    BaseServiceModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
