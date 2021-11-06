import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoopFormComponent } from './loop-form/loop-form.component';
import {RouterModule} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";



@NgModule({
  declarations: [
    LoopFormComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {path: 'loop-form', component: LoopFormComponent}
    ]),
    ReactiveFormsModule
  ]
})
export class OneModule { }
