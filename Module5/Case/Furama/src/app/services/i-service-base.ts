import {Observable} from "rxjs";
import {FormBuilder, FormGroup} from "@angular/forms";

export var formBuilderService = new FormBuilder();
export var baseApiUrl = "http://localhost:8080/api";

export interface IServiceBase<Obj> {

  getAll(): Observable<Obj[]>;

  getOne(id: any): Observable<Obj>;

  addOrUpdate(formGroup: FormGroup): any;

  delete(id: any): any;

}
