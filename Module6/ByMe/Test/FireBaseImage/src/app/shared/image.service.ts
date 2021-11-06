import { Injectable } from '@angular/core';
import {AngularFireDatabase, AngularFireList} from "@angular/fire/compat/database";

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  imageDetailList: AngularFireList<any> | any;

  constructor(
    private angularFireDatabase: AngularFireDatabase
  ) { }

  getImageDetailList() {
    this.imageDetailList = this.angularFireDatabase.list('imageDetails');
  }

  insertImageDetails(imageDetails : any) {
    this.imageDetailList.push(imageDetails);
  }
}
