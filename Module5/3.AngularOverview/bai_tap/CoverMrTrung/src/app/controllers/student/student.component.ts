import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Student} from "../../models/student";
import {IStudent} from "../../models/istudent";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css'],
})
export class StudentComponent implements OnInit {

  @Input() messageChild: string | any;
  @Input() studentDetailChild!: IStudent | any;

  @Output() sendObjIStudent = new EventEmitter();

  newObjIStudent: IStudent = {age: 0, avatar: "", id: 0, name: "", scores: 0};

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
    if (this.messageChild == undefined){
      this.messageChild = 'child';
    }

    if (this.studentDetailChild == undefined){
      this.studentDetailChild = {
        id: this.student.id,
        name: this.student.name,
        age: this.student.age,
        avatar: this.student.avatar,
        scores: this.student.scores
      };
    }

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

  btnAddStudent(){
    this.sendObjIStudent.emit(this.newObjIStudent);
  };

  getIdStudentFromForm(value: number){
    this.newObjIStudent.id = value;
  }
  getNameStudentFromForm(value: string){
    this.newObjIStudent.name = value;
  }
  getAgeStudentFromForm(value: number){
    this.newObjIStudent.age = value;
  }
  getAvatarStudentFromForm(value: string){
    this.newObjIStudent.avatar = value;
  }
  getScoreStudentFromForm(value: number){
    this.newObjIStudent.scores = value;
  }

}
