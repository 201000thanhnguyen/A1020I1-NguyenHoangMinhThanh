import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../base-service/customer.service";
import {FormGroup} from "@angular/forms";
import {formGroupCustomer, ICustomer} from "../../models/customer";
import {Subject} from "rxjs";
import {ICustomerType} from "../../models/customer-type";
import {CustomerTypeService} from "../../base-service/customer-type.service";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  formGroup!: FormGroup;
  customerArr: ICustomer[] = [];
  customerTypeArr: ICustomerType[] = [];

  attrHidden: boolean = false;

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject<any>();

  constructor(
    private customerService: CustomerService,
    private customerTypeService: CustomerTypeService
  ) { }

  ngOnInit(): void {
    this.formGroup = formGroupCustomer;

    this.getAllCustomer();
    this.customerTypeService.getAll().subscribe(
      (data) => {
        this.customerTypeArr = data;
      }
    );
  }

  getAllCustomer(){
    this.customerService.getAll().subscribe(
      (data) => {
        this.customerArr = data;
        this.dtTrigger.next();
      }
    );
  }

  getOneCustomer(id: any){
    this.customerService.getOne(id).subscribe(
      (data) => {
        Object.keys(this.formGroup.controls).forEach( key => {
          // @ts-ignore
          this.formGroup.controls[key].setValue(data[key]);
        })
      }
    );
  }

  btnAdd(){
    this.attrHidden = false;
    this.formGroup.enable();
    this.formGroup.reset();
  }

  btnEdit(id: any){
    this.attrHidden = false;
    this.formGroup.enable();
    this.getOneCustomer(id);
  }

  btnDelete(id: any){
    this.attrHidden = true;
    this.formGroup.disable();
    this.getOneCustomer(id);
  }

  submitAddOrUpdate(){
    this.customerService.addOrUpdate(this.formGroup).subscribe(
      () => {
        this.resetForm();
      }
    );
  }

  submitDelete(id: any){
    this.customerService.delete(id).subscribe(
      () => {
        this.resetForm();
      }
    );
  }

  resetForm(){
    $('.data-table').DataTable().destroy();
    this.formGroup.reset();
    this.getAllCustomer();
  }

}
