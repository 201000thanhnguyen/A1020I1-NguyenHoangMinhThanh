import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {OfThanhModule} from "./of-thanh/of-thanh.module";
import {OfCongModule} from "./of-cong/of-cong.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    OfThanhModule,
    OfCongModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
