import {Component, ElementRef, OnInit, Renderer2, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-loop-form',
  templateUrl: './loop-form.component.html',
  styleUrls: ['./loop-form.component.css']
})
export class LoopFormComponent implements OnInit {

  sttForm: number = 0;
  formGroup: FormGroup[] = [];
  serviceArr: any = [];

  constructor(
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.serviceArr = [
      {id: 1, serviceId: 'SV001', serviceName: 'Pool', quantity: 2, unit: 'cái', price: 100000},
      {id: 2, serviceId: 'SV002', serviceName: 'Pool2', quantity: 3, unit: 'cái', price: 200000},
      {id: 3, serviceId: 'SV003', serviceName: 'Pool3', quantity: 4, unit: 'cái', price: 300000}
    ]
  }

  btnAddService() {
    for (let i = 0; i <= this.sttForm; i++) {
      if (this.formGroup[i]){
        continue
      }
      this.formGroup[i] = this.formBuilder.group({
        id: [''],
        serviceId: [''],
        serviceName: [''],
        quantity: [''],
        unit: [''],
        price: ['']
      });
    }
    this.sttForm++;

  }

  async submitAddService() {
    if (this.formGroup.length > 0) {
      for (let i = 0; i < this.formGroup.length; i++) {
        this.serviceArr.push(this.formGroup[i].value);
      }
    }
    this.formGroup = [];
    this.sttForm = 0;
  }

}
