import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {DataTablesModule} from "angular-datatables";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {ForFuramaModule} from "./for-furama/for-furama.module";
import { ForFuramaComponent } from './for-furama/for-furama.component';

@NgModule({
  declarations: [
    AppComponent,
    ForFuramaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    DataTablesModule,
    ReactiveFormsModule,
    RouterModule,
    ForFuramaModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
