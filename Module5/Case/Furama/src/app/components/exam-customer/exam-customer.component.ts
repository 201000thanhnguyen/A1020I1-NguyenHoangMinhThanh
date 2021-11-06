import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";
import {IExamCustomer} from "../../models/exam-customer";
import {IExamCustomerType} from "../../models/exam-customer-type";
import {ExamCustomerService} from "../../services/exam-customer.service";
import {ExamCustomerTypeService} from "../../services/exam-customer-type.service";

@Component({
  selector: 'app-exam-customer',
  templateUrl: './exam-customer.component.html',
  styleUrls: ['./exam-customer.component.css']
})
export class ExamCustomerComponent implements OnInit {

  formGroup!: FormGroup;
  customerArr: IExamCustomer[] = [];
  customerTypeArr: IExamCustomerType[] = [];

  attrHiddenBtnAdd: boolean = true;
  attrHiddenBtnEdit: boolean = true;
  attrHiddenBtnDelete: boolean = true;
  attrHiddenBtnSearch: boolean = true;

  constructor(
    private customerService: ExamCustomerService,
    private customerTypeService: ExamCustomerTypeService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {

    this.formGroup = this.formBuilder.group({
      id: [''],
      name: ['',[Validators.required]],
      birthday: ['',[Validators.required]],
      gender: ['',[Validators.required]],
      email: ['',[Validators.required]],
      address: ['',[Validators.required]],
      customerType: ['',[Validators.required]]
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
    this.customerTypeService.getAll().subscribe(
      (data) => {
        this.customerTypeArr = data;
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
    let querySearch1 = '';
    for (let [key, value] of Object.entries(this.formGroup.value)) {

      if (key != 'id') {
        // backup
        if (key == 'customerType' && this.formGroup.controls.customerType.value){
          querySearch = `${key}.name_like=${this.formGroup.controls.customerType.value.name}`;
        }else {
          querySearch = `${key}_like=${value}`;
        }
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

export function validAgeValidators(min: number, max: number): ValidatorFn {
  return (control: AbstractControl): ValidationErrors => {
    let birthday = new Date(control.value);
    let age = (Date.now() - birthday.getTime()) / 31536000000;
    if (age < min || age > max) {
      return {"invalidAge": true}
    }
    // @ts-ignore
    return null;
  };
}
