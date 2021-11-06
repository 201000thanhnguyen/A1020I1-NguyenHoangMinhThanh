import { Component, OnInit } from '@angular/core';
import {ExCustomerService} from "../../services/ex-customer.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {IExCustomer} from "../../models/ex-customer";

@Component({
  selector: 'app-ex-customer',
  templateUrl: './ex-customer.component.html',
  styleUrls: ['./ex-customer.component.css']
})
export class ExCustomerComponent implements OnInit {


  formGroup!: FormGroup;
  customerArr: IExCustomer[] = [];

  attrHiddenBtnAdd: boolean = true;
  attrHiddenBtnEdit: boolean = true;
  attrHiddenBtnDelete: boolean = true;
  attrHiddenBtnSearch: boolean = true;

  constructor(
    private customerService: ExCustomerService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {

    this.formGroup = this.formBuilder.group({
      id: [''],
      name: ['',[Validators.required]]
    });

    this.getAllCustomer();
    this.getAllCustomerType();

  }

  getAllCustomer(){
    this.customerService.getAll().subscribe(
      (data) => {
        this.customerArr = data;
      }
    );
  }

  getAllCustomerType(){
    this.customerService.getAll().subscribe(
      (data) => {
        this.customerArr = data;
      }
    );
  }

  getOneCustomer(id: any){
    this.customerService.getOne(id).subscribe(
      (data) => {
        Object.keys(this.formGroup.controls).forEach(
          (key) => {
            // @ts-ignore
            this.formGroup.controls[key].setValue(data[key]);
          }
        );
      }
    );
  }

  btnAdd(){
    this.attrHiddenBtnAdd = false;
    this.attrHiddenBtnDelete = true;
    this.attrHiddenBtnEdit = true;
    this.attrHiddenBtnSearch = true;
    this.formGroup.reset();
    this.formGroup.enable();
  }

  btnEdit(id: any){
    this.attrHiddenBtnAdd = true;
    this.attrHiddenBtnDelete = true;
    this.attrHiddenBtnEdit = false;
    this.attrHiddenBtnSearch = true;
    this.formGroup.enable();
    this.getOneCustomer(id);
  }

  btnDelete(id: any){
    this.attrHiddenBtnAdd = true;
    this.attrHiddenBtnDelete = false;
    this.attrHiddenBtnEdit = true;
    this.attrHiddenBtnSearch = true;
    this.formGroup.disable();
    this.getOneCustomer(id);
  }

  btnDetail(id: any){
    this.attrHiddenBtnAdd = true;
    this.attrHiddenBtnDelete = true;
    this.attrHiddenBtnEdit = true;
    this.attrHiddenBtnSearch = true;
    this.getOneCustomer(id);
    this.formGroup.disable();
  }

  btnSearch(){
    this.attrHiddenBtnAdd = true;
    this.attrHiddenBtnDelete = true;
    this.attrHiddenBtnEdit = true;
    this.attrHiddenBtnSearch = false;
    this.formGroup.reset();
    this.formGroup.enable();
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

  submitSearch(){
    this.customerArr = [];
    // handle if have key search
    let querySearch = '';
    for (let [key, value] of Object.entries(this.formGroup.value)) {

      if (key != 'id') {
        // backup
        if (key == 'customerType' && this.formGroup.controls.customerType.value){
          querySearch = `${key}.name_like=${this.formGroup.controls.customerType.value.name}`;
        }else {
          querySearch = `${key}_like=${value}`;
        }
        console.log(querySearch);
        // backup
        this.customerService.getLike(querySearch).subscribe(
          (data) => {
            data.forEach(
              (o, i, a) => {
                if (!this.customerArr.some((s) => JSON.stringify(s) == JSON.stringify(o))){
                  this.customerArr.push(o);
                }
              }
            );
          }
        );
      }
    }
  }

  compareWith(c1: any, c2: any) {
    if (c1 != null && c2 != null) {
      return c1.id === c2.id;
    }
    return false;
  }

  resetForm(){
    this.formGroup.reset();
    this.getAllCustomer();
  }

}
