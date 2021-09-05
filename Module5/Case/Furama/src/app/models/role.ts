export class Role implements IRole {
  roleId: number;
  roleName: string;

  constructor(roleId: number, roleName: string) {
    this.roleId = roleId;
    this.roleName = roleName;
  }
}

export interface IRole {
  roleId: number;
  roleName: string;
}
