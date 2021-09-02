import { Component, OnInit } from '@angular/core';
import {Student} from "../../models/student";
import {IStudent, iStudentList} from "../../models/istudent";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

   studentList = iStudentList;

  messageParent: string | undefined;
  studentDetailParent: IStudent | undefined;

  receiveObjIStudent(value: Student){
    console.log(value);
    this.studentList.push(new Student(value.studentId, value.studentName, value.studentAge, value.studentAvatar, value.studentScores));
  }

  constructor() {
  }

  ngOnInit(): void {
  }

  clickDetailStudent(value: number){
    // for (let i = 0; i < this.studentList.length; i++) {
    //   if (this.studentList[i].id == value){
    //     this.studentDetailParent = this.studentList[i];
    //     this.messageParent = "parent";
    //   }
    // }

    this.studentDetailParent = this.studentList.find(x => x.studentId == value);
    console.log(this.studentDetailParent);
  }

  clickDeleteStudent(value: number){
    this.studentList.splice(value-1, 1);
  }
}
