import {Position} from "./position";
import {IEducationDegree} from "./education-degree";
import {IDivision} from "./division";
import {IUser} from "./user";

export class Employee implements IEmployee{
  division: IDivision;
  educationDegree: IEducationDegree;
  employeeAddress: string;
  employeeBirthday: string;
  employeeEmail: string;
  employeeId: number;
  employeeIdCard: string;
  employeeName: string;
  employeePhone: string;
  employeeSalary: number;
  position: Position;
  user: IUser;

  constructor(division: IDivision, educationDegree: IEducationDegree, employeeAddress: string, employeeBirthday: string,
              employeeEmail: string, employeeId: number, employeeIdCard: string, employeeName: string,
              employeePhone: string, employeeSalary: number, position: Position, userName: IUser) {
    this.division = division;
    this.educationDegree = educationDegree;
    this.employeeAddress = employeeAddress;
    this.employeeBirthday = employeeBirthday;
    this.employeeEmail = employeeEmail;
    this.employeeId = employeeId;
    this.employeeIdCard = employeeIdCard;
    this.employeeName = employeeName;
    this.employeePhone = employeePhone;
    this.employeeSalary = employeeSalary;
    this.position = position;
    this.user = userName;
  }
}

export interface IEmployee {
  employeeId: number;
  employeeName: string;
  employeeBirthday: string;
  employeeIdCard: string;
  employeeSalary: number;
  employeePhone: string;
  employeeEmail: string;
  employeeAddress: string;

  position: Position;
  educationDegree: IEducationDegree;
  division: IDivision;
  user: IUser;
}
