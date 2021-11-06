import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import { WebFreetutsComponent } from './web-freetuts/web-freetuts.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";


@NgModule({
  declarations: [
    WebFreetutsComponent
  ],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    RouterModule.forRoot([
      {path: "web1", component: WebFreetutsComponent}
    ])
  ]
})
export class WebsModule { }
