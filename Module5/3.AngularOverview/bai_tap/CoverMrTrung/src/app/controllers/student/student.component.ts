import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Student} from "../../models/student";
import {IStudent} from "../../models/istudent";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css'],
})
export class StudentComponent implements OnInit {

  constructor(private formBuilder: FormBuilder) {
  }

  @Input() messageChild: string | any;
  @Input() studentDetailChild!: IStudent | any;

  @Output() eventEmitter = new EventEmitter();

  @Input() objStudentForForm: IStudent | any;
  objGetDataFromForm = this.formBuilder.group({
    studentId: '',
    studentName: '',
    studentAge: '',
    studentAvatar: '',
    studentScores: ''
  });
  onAddStudentFrom() : void{
    this.objStudentForForm = this.objGetDataFromForm.value;
    console.log(this.objGetDataFromForm.value);
    console.log(this.objStudentForForm.studentName);
    this.eventEmitter.emit(this.objStudentForForm);
  }

  newObjIStudent: IStudent = {studentAge: 0, studentAvatar: "", studentId: 0, studentName: "", studentScores: 0};

  student: Student = new Student(
    1,
    "aloha",
    20,
    'https://www.pinpng.com/pngs/m/341-3415688_no-avatar-png-transparent-png.png',
    0
  );

  fontSize = 14;
  idStudent: number = this.student.studentId;
  avatarStudent: string = this.student.studentAvatar;

  output: number = 0;
  first: number = 0;
  second: number = 0;
  operator = '+';

  background = '#00e067';

  petName = 'puppie';
  petImage = 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg';


  ngOnInit(): void {
    if (this.messageChild == undefined){
      this.messageChild = 'child';
    }

    if (this.studentDetailChild == undefined){
      this.studentDetailChild = {
        studentId: this.student.studentId,
        studentName: this.student.studentName,
        studentAge: this.student.studentAge,
        studentAvatar: this.student.studentAvatar,
        studentScores: this.student.studentScores
      };
    }
  }

  changeScores(value: any){
    this.student.studentName = value;
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
    // this.sendObjIStudent.emit(this.newObjIStudent);
    this.eventEmitter.emit(this.objStudentForForm);
  };

  getIdStudentFromForm(value: number){
    this.newObjIStudent.studentId = value;
  }
  getNameStudentFromForm(value: string){
    this.newObjIStudent.studentName = value;
  }
  getAgeStudentFromForm(value: number){
    this.newObjIStudent.studentAge = value;
  }
  getAvatarStudentFromForm(value: string){
    this.newObjIStudent.studentAvatar = value;
  }
  getScoreStudentFromForm(value: number){
    this.newObjIStudent.studentScores = value;
  }

}
