export class ServiceType implements IServiceType{
  serviceTypeId: number;
  serviceTypeName: string;

  constructor(serviceTypeId: number, serviceTypeName: string) {
    this.serviceTypeId = serviceTypeId;
    this.serviceTypeName = serviceTypeName;
  }
}

export interface IServiceType {
  serviceTypeId: number;
  serviceTypeName: string;
}
