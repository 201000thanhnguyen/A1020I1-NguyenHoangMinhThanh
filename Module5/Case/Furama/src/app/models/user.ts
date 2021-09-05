import {IRole} from "./role";

export class User implements IUser{
  password: string;
  userName: string;
  role: IRole;

  constructor(password: string, userName: string, role: IRole) {
    this.password = password;
    this.userName = userName;
    this.role = role;
  }
}

export interface IUser {
  userName: string;
  password: string;
  role: IRole;
}
