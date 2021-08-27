import { Component, OnInit } from '@angular/core';
import {Student} from "../../models/student";
import {IStudent} from "../../models/istudent";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  studentList: IStudent[] = [
    new Student(1, "aloha 100", 20, '', 0),
    new Student(2, "aloha 101", 20, '', 10),
    new Student(3, "aloha 102", 20, '', 2),
    new Student(4, "aloha 103", 20, '', 3)
  ];

  messageParent: string | undefined = undefined;
  studentDetailParent: IStudent | undefined;

  receiveObjIStudent(value: Student){
    console.log(value);
    this.studentList.push(new Student(value.id, value.name, value.age, value.avatar, value.scores));
  }

  constructor() {
  }

  ngOnInit(): void {
  }

  clickDetailStudent(value: number){
    for (let i = 0; i < this.studentList.length; i++) {
      if (this.studentList[i].id == value){
        this.studentDetailParent = this.studentList[i];
        this.messageParent = "parent";
      }
    }
    console.log(this.studentDetailParent);
  }

  clickDeleteStudent(value: number){
    this.studentList.splice(value-1, 1);
  }
}
