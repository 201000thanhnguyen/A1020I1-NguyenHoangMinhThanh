import {Component, OnInit, Output, EventEmitter, ViewChild} from '@angular/core';
import {CustomerTypeService} from "../../services/customer-type.service";
import {CustomerType, ICustomerType} from "../../models/customer-type";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-customer-type',
  templateUrl: './customer-type.component.html',
  styleUrls: ['./customer-type.component.css']
})
export class CustomerTypeComponent implements OnInit {

  customerTypeArr: ICustomerType[] = [];
  formGroup!: FormGroup;

  constructor(
    private customerTypeService: CustomerTypeService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      id: [''],
      name: ['',[Validators.required]]
    });
    this.getAllCustomerType();
  }

  getAllCustomerType(){
    this.customerTypeService.getAll().subscribe(
      (data) => {
        this.customerTypeArr = data;
      }
    );
  }

  onDeactivate() {
    this.getAllCustomerType();
  }

  searchCustomerType(keySearch: any) {
    if (!keySearch){
      this.getAllCustomerType();
    }else {
      this.customerTypeArr = [];
      // handle if have key search
      let querySearchCustomerType = '';
      for (let [key, value] of Object.entries(this.formGroup.value)){
        if (key != 'id'){
          querySearchCustomerType = `${key}_like=${keySearch}`;
          this.customerTypeService.getLike(querySearchCustomerType).subscribe(
            (data) => {
              data.forEach(o => {this.customerTypeArr.push(o)});
              // filter duplicate objects
              this.customerTypeArr = this.customerTypeArr.filter(
                (o, i, a) => {
                  return a.indexOf(o) == i;
                }
              );
            }
          );
        }
      }
    }
  }

  btnDelete(id: any) {
    this.customerTypeService.getOne(id).subscribe(
      (data) => {
        Object.keys(this.formGroup.controls).forEach(
          (key) => {
            // @ts-ignore
            this.formGroup.controls[key].setValue(data[key]);
          }
        );
      }
    );
    this.formGroup.disable();
  }

  submitDelete(id: any) {
    this.customerTypeService.delete(id).subscribe(
      () => {
        this.getAllCustomerType();
      }
    );
  }
}
