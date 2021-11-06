import { Component, OnInit } from '@angular/core';
import {CustomerTypeService} from "../../base-service/customer-type.service";
import {FormGroup} from "@angular/forms";
import {formGroupCustomerType, ICustomerType} from "../../models/customer-type";
import {Subject} from "rxjs";

@Component({
  selector: 'app-customer-type',
  templateUrl: './customer-type.component.html',
  styleUrls: ['./customer-type.component.css']
})
export class CustomerTypeComponent implements OnInit {

  formGroup!: FormGroup;
  customerTypeArr: ICustomerType[] = [];

  attrReadonly: boolean = false;
  attrHidden: boolean = false;

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject<any>();

  constructor(private customerTypeService: CustomerTypeService) { }

  ngOnInit(): void {
    this.formGroup = formGroupCustomerType;
    this.getAllCustomerType();
  }

  getAllCustomerType(){
    this.customerTypeService.getAll().subscribe(
      (data) => {
        this.customerTypeArr = data;
        this.dtTrigger.next();
      }
    );
  }

  getOneCustomerType(id: any){
    this.customerTypeService.getOne(id).subscribe(
      (data) => {
        Object.keys(this.formGroup.controls).forEach( key => {
            // @ts-ignore
            this.formGroup.controls[key].setValue(data[key]);
          }
        );
      }
    );
  }

  btnAdd(){
    this.attrHidden = false;
    this.attrReadonly = false;
    this.formGroup.reset();
  }

  btnEdit(id: any){
    this.attrHidden = false;
    this.attrReadonly = false;
    this.getOneCustomerType(id);
  }

  submitAddOrUpdate(){
    this.customerTypeService.addOrUpdate(this.formGroup).subscribe(
      () => {
        this.resetForm();
      }
    );
  }

  btnDelete(id: any){
    this.attrHidden = true;
    this.attrReadonly = true;
    this.getOneCustomerType(id);
  }

  submitDelete(id: any){
    this.customerTypeService.delete(id).subscribe(
      () => {
        this.resetForm();
      }
    );
  }

  resetForm(){
    $('.data-table').DataTable().destroy();
    this.formGroup.reset();
    this.getAllCustomerType();
  }

}
