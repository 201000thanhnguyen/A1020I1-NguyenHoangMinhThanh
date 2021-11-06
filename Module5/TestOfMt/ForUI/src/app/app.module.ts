import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {YoutubeModule} from "./youtube/youtube.module";
import {DocsModule} from "./docs/docs.module";
import {WebsModule} from "./webs/webs.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    YoutubeModule,
    WebsModule,
    DocsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
