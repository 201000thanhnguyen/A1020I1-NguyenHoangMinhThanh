import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AngularFireStorage} from "@angular/fire/compat/storage";
import {finalize} from "rxjs/operators";
import {ImageService} from "../../shared/image.service";

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {

  imgSrc : string = '/assets/img/4.jpg';
  selectedImage: any = null;

  formTemplate = new FormGroup({
    caption: new FormControl('', Validators.required),
    category: new FormControl('', Validators.required),
    imageUrl: new FormControl('', Validators.required)
  });

  constructor(
    private angularFireStorage: AngularFireStorage,
    private imageService: ImageService
  ) { }

  ngOnInit(): void {
  }

  showPreview(event: any) {
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (e: any) => this.imgSrc = e.target.result;
      reader.readAsDataURL(event.target.files[0]);
      this.selectedImage = event.target.files[0];
    }else {
      this.imgSrc = '/assets/img/4.jpg';
      this.selectedImage = null;
    }
  }

  onSubmit(value: any) {
    if (this.formTemplate.valid){
      let filePath = `${value.category}/${this.selectedImage.name.split('.').slice(0,-1).join('.')}_${new Date().getTime()}`;
      const fileRef = this.angularFireStorage.ref(filePath);
      this.angularFireStorage.upload(filePath, this.selectedImage).snapshotChanges().pipe(
        finalize(
          () => {
            fileRef.getDownloadURL().subscribe(
              (url) => {
                value['imageUrl'] = url;
                this.imageService.insertImageDetails(value);
                this.resetForm();
              }
            )
          }
        )
      ).subscribe();
      console.log(filePath);
    }
  }

  resetForm(){
    this.formTemplate.reset();
    this.imgSrc = '/assets/img/4.jpg';
    this.selectedImage = null;
  }
}
