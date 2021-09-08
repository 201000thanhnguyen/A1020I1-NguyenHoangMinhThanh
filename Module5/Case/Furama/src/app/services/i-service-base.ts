import {Observable} from "rxjs";
import {FormBuilder, FormGroup} from "@angular/forms";

export var formBuilderService = new FormBuilder();
export var apiBaseUrl = "http://localhost:8080/api";

export interface IServiceBase<Obj> {

  getAll(): Observable<Obj[]>;

  getOne(id: any): Observable<Obj>;

  addOrUpdate(formGroup: FormGroup): Observable<Object>;

  delete(id: any): Observable<Object>;

}
