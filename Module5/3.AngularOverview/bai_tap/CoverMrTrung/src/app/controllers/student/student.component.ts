import { Component, OnInit } from '@angular/core';
import {Student} from "../../models/student";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css'],
})
export class StudentComponent implements OnInit {

  student: Student = new Student(
    1,
    "aloha",
    20,
    'https://www.pinpng.com/pngs/m/341-3415688_no-avatar-png-transparent-png.png',
    0
  );

  fontSize = 14;
  idStudent: number = this.student.id;
  avatarStudent: string = this.student.avatar;

  output: number = 0;
  first: number = 0;
  second: number = 0;
  operator = '+';

  background = '#00e067';

  petName = 'puppie';
  petImage = 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg';

  constructor() {
  }

  ngOnInit(): void {
  }

  changeScores(value: any){
    this.student.name = value;
  }

  changeFontSize(value: any) {
    this.fontSize = value;
  }

  onFirstChange(value: any) {
    this.first = Number(value);
  }
  onSecondChange(value: any) {
    this.second = Number(value);
  }
  onSelectChange(value: any) {
    this.operator = value;
  }

  calculate() {
    switch (this.operator) {
      case '+':
        this.output = this.first + this.second;
        break;
      case '-':
        this.output = this.first - this.second;
        break;
      case '*':
        this.output = this.first * this.second;
        break;
      case '/':
        this.output = this.first / this.second;
        break;
    }
  }

  onChangeBackgroundColor(value: any) {
    this.background = value;
  }

  updateNamePet(value: any) {
    this.petName = value;
  }

  updateImagePet(value: any) {
    this.petImage = value;
  }
}
