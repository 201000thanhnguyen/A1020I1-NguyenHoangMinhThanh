import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import {OneComponent} from "./one/one.component";



@NgModule({
  declarations: [
    OneComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {path: 'one', component: OneComponent}
    ])
  ]
})
export class DocsModule { }
