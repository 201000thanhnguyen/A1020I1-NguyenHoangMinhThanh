import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from "@angular/router";
import {Student} from "../../models/student";
import {IStudent, iStudentList} from "../../models/istudent";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  studentList = iStudentList;
  student: Student | any;
  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const routerParams = this.activatedRoute.snapshot.paramMap;
    const studentIdFromRoute = Number(routerParams.get('studentId'));
    this.student = this.studentList.find(student => student.studentId == studentIdFromRoute);
  }

}
