import {Student} from "./student";

export interface IStudent {
  studentId: number;
  studentName: string;
  studentAge: number;
  studentAvatar?: string;
  studentScores: number;
}

export const iStudentList: IStudent[] = [
    new Student(1, "aloha 100", 20, '', 0),
    new Student(2, "aloha 101", 20, '', 10),
    new Student(3, "aloha 102", 20, '', 2),
    new Student(4, "aloha 103", 20, '', 3)
];
