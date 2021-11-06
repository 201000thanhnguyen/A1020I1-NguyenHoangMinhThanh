import {Component, OnDestroy, OnInit} from '@angular/core';
import {CustomerTypeService} from "../../services/customer-type.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {CustomerType, formGroupCustomerType} from "../../models/customer-type";
import {Subject} from "rxjs";

@Component({
  selector: 'app-customer-type',
  templateUrl: './customer-type.component.html',
  styleUrls: ['./customer-type.component.css']
})
export class CustomerTypeComponent implements OnInit, OnDestroy {

  formGroup!: FormGroup;
  customerTypeArr: CustomerType[] = [];

  // for modal
  attributeReadonly: boolean = false;
  attributeHidden: boolean = false;

  dataTable: any;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject<any>();

  constructor(
    private customerTypeService: CustomerTypeService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.formGroup = formGroupCustomerType;

    this.getCustomerTypeList();
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }

  inverseValueAttribute(){
    if (this.attributeReadonly || this.attributeHidden){
      this.attributeReadonly = false;
      this.attributeHidden = false;
    }
  }

  getCustomerTypeList(): void{
    this.customerTypeService.getAll().subscribe(
      (data) => {
        this.customerTypeArr = data;
        this.dtTrigger.next();
      })
  }

  getCustomerType(id: any): void{
    this.customerTypeService.getOne(id).subscribe(
      (data) => {
        Object.keys(this.formGroup.controls).forEach( key => {
          // @ts-ignore
          this.formGroup.controls[key].setValue(data[key]);
        });
      }
    );
  }

  btnAdd() {
    this.inverseValueAttribute();
    this.formGroup.reset();
  }

  btnEdit(id: number) {
    this.inverseValueAttribute();
    this.getCustomerType(id);
  }

  submitAddOrUpdate() {
    this.customerTypeService.addOrUpdate(this.formGroup).subscribe(
      () => {
        this.resetForm();
      }
    )
  }

  btnDelete(id: number) {
    this.getCustomerType(id);
    this.attributeHidden = true;
    this.attributeReadonly = true;
  }

  submitDelete(id: any) {
    this.customerTypeService.delete(id).subscribe(
      () => {
        this.resetForm();
      }
    )
  }

  resetForm(){
    $('.data-table').DataTable().destroy();
    this.formGroup.reset();
    this.getCustomerTypeList();
  }
}
