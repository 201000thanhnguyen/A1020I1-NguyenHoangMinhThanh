import { Component, OnInit } from '@angular/core';
import {ImageService} from "../../shared/image.service";

@Component({
  selector: 'app-image-list',
  templateUrl: './image-list.component.html',
  styleUrls: ['./image-list.component.css']
})
export class ImageListComponent implements OnInit {

  imageList!: any[];
  rowIndexArray!: any[];

  constructor(
    private imageService: ImageService
  ) { }

  ngOnInit(): void {
    this.imageService.imageDetailList.snapshotChanges().subscribe(
      (list: any[]) => {
        this.imageList = list.map(
          item => { return item.payload.val() }
        );
        console.log(this.imageList);
        this.rowIndexArray = Array.from(Array(Math.ceil(this.imageList.length / 3)).keys());
      }
    );
  }

}
