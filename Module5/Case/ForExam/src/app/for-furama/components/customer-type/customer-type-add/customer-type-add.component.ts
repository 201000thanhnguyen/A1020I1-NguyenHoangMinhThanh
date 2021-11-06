import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CustomerTypeService} from "../../../services/customer-type.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-type-add',
  templateUrl: './customer-type-add.component.html',
  styleUrls: ['./customer-type-add.component.css']
})
export class CustomerTypeAddComponent implements OnInit {

  formGroup!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private customerTypeService: CustomerTypeService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      id: [''],
      name: ['']
    });
  }

  submitAdd() {
    this.customerTypeService.addOrUpdate(this.formGroup).subscribe(
      () => {
        this.router.navigateByUrl('/customer-type').then(
          () => {}
        );
      }
    );
  }
}
