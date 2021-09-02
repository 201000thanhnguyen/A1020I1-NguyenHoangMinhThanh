import {IStudent} from "./istudent";

export class Student implements IStudent{
  studentId: number;
  studentName: string;
  studentAge: number;
  studentAvatar: string;
  studentScores: number;

  constructor(id: number, name: string, age: number, avatar: string, scores: number) {
    this.studentId = id;
    this.studentName = name;
    this.studentAge = age;
    this.studentAvatar = avatar;
    this.studentScores = scores;
  }

}
