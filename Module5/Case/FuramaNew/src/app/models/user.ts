export class User implements IUser{
  password: string;
  userName: string;

  constructor(password: string, userName: string) {
    this.password = password;
    this.userName = userName;
  }
}

export interface IUser {
  userName: string;
  password: string;
}
