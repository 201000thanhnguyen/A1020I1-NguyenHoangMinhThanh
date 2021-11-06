import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CustomerTypeService} from "../../../services/customer-type.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-customer-type-edit',
  templateUrl: './customer-type-edit.component.html',
  styleUrls: ['./customer-type-edit.component.css']
})
export class CustomerTypeEditComponent implements OnInit {

  formGroup!: FormGroup;

  constructor(
    private customerTypeService: CustomerTypeService,
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,
    private router: Router
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
  }

  submitEdit() {
    this.customerTypeService.addOrUpdate(this.formGroup).subscribe(
      () => {

      }
    );
    this.router.navigateByUrl('/customer-type').then(
      () => {}
    );
  }
}
