import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subject} from "rxjs";
import {FormBuilder, FormGroup} from "@angular/forms";
import {CustomerService} from "../../services/customer.service";
import {Customer, formGroupCustomer} from "../../models/customer";
import {formBuilderService} from "../../services/i-service-base";
import {CustomerTypeService} from "../../services/customer-type.service";
import {CustomerType} from "../../models/customer-type";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit, OnDestroy {

  formGroup!: FormGroup;
  customerArr: Customer[] = [];
  customerTypeArr: CustomerType[] = [];

  dataTable: any;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject<any>();

  attributeReadonly: boolean = false;
  attributeHidden: boolean = false;

  constructor(
    private customerService: CustomerService,
    private customerTypeService: CustomerTypeService,
    private formBuilder: FormBuilder
  ) { }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }

  ngOnInit(): void {
    this.formGroup = formGroupCustomer;

    this.getCustomerList();
    this.getCustomerTypeList();
  }

  getCustomerList(){
    this.customerService.getAll().subscribe(
      (data) => {
        this.customerArr = data;
        this.customerArr.forEach(
          (customer) => {
            if (typeof customer.customerType == "number"){
              this.customerTypeService.getOne(customer.customerType).subscribe(
                (customerType) => {
                  customer.customerType = customerType;
                }
              );
            }
          }
        );
        this.dtTrigger.next();
      }
    )
  }

  getCustomer(id: any): void{
    this.customerService.getOne(id).subscribe(
      (data) => {
        Object.keys(this.formGroup.controls).forEach( key => {
          // @ts-ignore
          this.formGroup.controls[key].setValue(data[key]);
        });
      }
    );
  }

  getCustomerTypeList(){
    this.customerTypeService.getAll().subscribe(
      (data) => {
        this.customerTypeArr = data;
      }
    );
  }
  btnAdd() {
    this.inverseValueAttribute();
    this.formGroup.reset();
  }
  btnEdit(id: number) {
    this.inverseValueAttribute();
    this.getCustomer(id);
  }

  btnDelete(id: number) {
    this.getCustomer(id);
    this.attributeHidden = true;
    this.attributeReadonly = true;
  }

  submitAddOrUpdate() {
    this.customerService.addOrUpdate(this.formGroup).subscribe(
      () => {
        this.resetForm();
      }
    );
  }

  submitDelete(id: any) {
    this.customerService.delete(id).subscribe(
      () => {
        this.resetForm();
      }
    );
  }
  resetForm(){
    $('.data-table').DataTable().destroy();
    this.formGroup.reset();
    this.getCustomerList();
  }

  inverseValueAttribute(){
    if (this.attributeReadonly || this.attributeHidden){
      this.attributeReadonly = false;
      this.attributeHidden = false;
    }
  }

}
