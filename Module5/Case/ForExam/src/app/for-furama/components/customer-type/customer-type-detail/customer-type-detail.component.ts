import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {CustomerTypeService} from "../../../services/customer-type.service";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-customer-type-detail',
  templateUrl: './customer-type-detail.component.html',
  styleUrls: ['./customer-type-detail.component.css']
})
export class CustomerTypeDetailComponent implements OnInit {

  formGroup!: FormGroup;
  
  constructor(
    private customerTypeService: CustomerTypeService,
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {

    this.formGroup = this.formBuilder.group({
      id: [''],
      name: ['']
    });

    this.activatedRoute.paramMap.subscribe(
      (data) => {
        this.customerTypeService.getOne(data.get('id')).subscribe(
          (data) => {
            Object.keys(this.formGroup.controls).forEach(
              key => {
                // @ts-ignore
                this.formGroup.controls[key].setValue(data[key])
              }
            );
          }
        );
      }
    );

    this.formGroup.disable();
  }

}
