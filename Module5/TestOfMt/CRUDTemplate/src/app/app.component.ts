import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {AppService} from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'crud';

  baseURL = 'http://localhost:8080/api';
  formGroup: FormGroup;
  isSubmitted = false;
  brandList;

  constructor(
    private http: HttpClient,
    private formBuilder: FormBuilder,
    private appService: AppService
  ) { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      id: '',
      firstName: '',
      lastName: ''
    });

    this.getAll();
  }

  // get formBuilder() { return this.brandForm.controls; }

  // tslint:disable-next-line:typedef
  save() {
    // this.isSubmitted = true;
    // if (this.brandForm.invalid) {
    //   return;
    // } else{
    //   const id = this.brandForm.controls.id.value;
    //   if (!id){
    //     this.http.post(this.baseURL + '/customer', this.brandForm.value).subscribe(() => {
    //       // alert('Created successfully');
    //       this.reset();
    //     });
    //   } else {
    //     this.http.put(this.baseURL + '/customer/' + id, this.brandForm.value).subscribe(() => {
    //       // alert('Updated successfully');
    //       this.reset();
    //     });
    //   }
    // }
    this.appService.addOrUpdateCustomerService(this.formGroup).subscribe(() => { this.reset(); });
  }

  // tslint:disable-next-line:typedef
  reset(){
    this.formGroup.reset();
    // this.brandForm.controls.is_active.setValue(1);
    this.isSubmitted = false;

    this.getAll();
  }

  // tslint:disable-next-line:typedef
  getAll(){
    // this.http.get(this.baseURL + '/customer').subscribe((result) => {
    //   this.brandList = result;
    // });
    this.appService.getCustomerListService().subscribe(data => this.brandList = data);
  }

  // tslint:disable-next-line:typedef
  edit(id){
    if (id){
      // const brand = this.brandList.find(x => x.id === id);
      // if (!brand) { return; }
      // brand.isReading = true;

      // this.http.get(this.baseURL + '/customer/' + id).subscribe((result) => {
      this.appService.getCustomerService(id).subscribe(result => {
        Object.keys(this.formGroup.controls).forEach(key => {
          this.formGroup.controls[key].setValue(result[key]);
          console.log(key);
        });
        // brand.isReading = false;
        // alert('Edit data loaded successfully');
      });
    }
  }

  // tslint:disable-next-line:typedef
  delete(id){
    // tslint:disable-next-line:prefer-const
    let result = confirm('Want to delete?');
    if (id && result){
      // const brand = this.brandList.find(x => x.id === id);
      // if (!brand) { return; }
      // brand.isDeleting = true;
      //
      // this.http.delete(this.baseURL + '/customer/' + id).subscribe(() => {
      //   brand.isReading = false;
      //   this.reset();
      //   // alert('Removed successfully');
      // });
      this.appService.deleteCustomerService(id).subscribe(() => {
        this.reset();
      });
    }
  }
}

