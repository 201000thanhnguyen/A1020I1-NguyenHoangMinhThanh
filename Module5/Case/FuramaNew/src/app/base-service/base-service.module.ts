import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Observable} from "rxjs";
import {FormGroup} from "@angular/forms";

export var apiBaseService = "http://localhost:3000";

export interface IBaseService<Obj> {

  getAll(): Observable<Obj[]>;

  getOne(id: any): Observable<Obj>;

  addOrUpdate(formGroup: FormGroup): Observable<Object>;

  delete(id: any): Observable<Object>;

}

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class BaseServiceModule { }
