import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ExamComponent } from './exam.component';
import {RouterModule} from "@angular/router";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule} from "@angular/forms";



@NgModule({
  declarations: [
    ExamComponent
  ],
  exports: [
    ExamComponent
  ],
  imports: [
    CommonModule,
    NgbModule,
    FormsModule,
    RouterModule.forRoot([

    ]),
  ]
})
export class ExamModule { }
