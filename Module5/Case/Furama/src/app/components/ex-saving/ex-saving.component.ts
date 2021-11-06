import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ExSaving, IExSaving} from "../../models/ex-saving";
import {ExCustomerService} from "../../services/ex-customer.service";
import {ExSavingService} from "../../services/ex-saving.service";
import {IExCustomer} from "../../models/ex-customer";

@Component({
  selector: 'app-ex-saving',
  templateUrl: './ex-saving.component.html',
  styleUrls: ['./ex-saving.component.css']
})
export class ExSavingComponent implements OnInit {

  formGroup!: FormGroup;
  savingArr: IExSaving[] = [];
  customerArr: IExCustomer[] = [];

  attrHiddenBtnAdd: boolean = true;
  attrHiddenBtnEdit: boolean = true;
  attrHiddenBtnDelete: boolean = true;
  attrHiddenBtnSearch: boolean = true;

  constructor(
    private exSavingService: ExSavingService,
    private exCustomerService: ExCustomerService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      id: [''],
      exCustomer: ['',[Validators.required]],
      dateOpenSaving: ['',[Validators.required]],
      timeSaving: ['',[Validators.required]],
      term: ['',[Validators.required]],
      money: ['',[Validators.required, Validators.min(10000000)]],
      interest: ['',[Validators.required]],
      incentives: ['',[Validators.required]],
    });

    this.getAll();
    this.getAllCustomer();
  }

  getAll(){
    this.exSavingService.getAll().subscribe(
      (data) => {
        this.savingArr = data;
      }
    );
  }

  getAllCustomer(){
    this.exCustomerService.getAll().subscribe(
      (data) => {
        this.customerArr = data;
      }
    );
  }


  getOne(id: any){
    this.exSavingService.getOne(id).subscribe(
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
    this.getOne(id);
  }

  btnDelete(id: any){
    this.attrHiddenBtnAdd = true;
    this.attrHiddenBtnDelete = false;
    this.attrHiddenBtnEdit = true;
    this.attrHiddenBtnSearch = true;
    this.formGroup.disable();
    this.getOne(id);
  }

  btnDetail(id: any){
    this.attrHiddenBtnAdd = true;
    this.attrHiddenBtnDelete = true;
    this.attrHiddenBtnEdit = true;
    this.attrHiddenBtnSearch = true;
    this.getOne(id);
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
    this.exSavingService.addOrUpdate(this.formGroup).subscribe(
      () => {
        this.resetForm();
      }
    );
  }

  submitDelete(id: any){
    this.exSavingService.delete(id).subscribe(
      () => {
        this.resetForm();
      }
    );
  }
  resetForm(){
    this.formGroup.reset();
    this.getAll();
  }

  compareWith(c1: any, c2: any) {
    if (c1 != null && c2 != null) {
      return c1.id === c2.id;
    }
    return false;
  }

  submitSearch(){
    this.savingArr = [];
    // handle if have key search
    let querySearch = '';
    for (let [key, value] of Object.entries(this.formGroup.value)) {

      // if (key != 'id') {
      // backup
      if (key == 'exCustomer' && this.formGroup.controls.exCustomer.value){
        querySearch = `${key}.name_like=${value}`;
      }else {
        querySearch = `${key}_like=${value}`;
      }
      // backup
      this.exSavingService.getLike(querySearch).subscribe(
        (data) => {
          data.forEach(
            (o, i, a) => {
              if (!this.savingArr.some((s) => JSON.stringify(s) == JSON.stringify(o))){
                this.savingArr.push(o);
              }
            }
          );
        }
      );
      // }
    }
  }

}
