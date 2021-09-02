export class AttachService implements IAttachService{
  attachServiceCost: number;
  attachServiceId: number;
  attachServiceName: string;
  attachServiceStatus: string;
  attachServiceUnit: number;

  constructor(attachServiceCost: number, attachServiceId: number, attachServiceName: string, attachServiceStatus: string, attachServiceUnit: number) {
    this.attachServiceCost = attachServiceCost;
    this.attachServiceId = attachServiceId;
    this.attachServiceName = attachServiceName;
    this.attachServiceStatus = attachServiceStatus;
    this.attachServiceUnit = attachServiceUnit;
  }
}

export interface IAttachService {
  attachServiceId: number;
  attachServiceName: string;
  attachServiceCost: number;
  attachServiceUnit: number;
  attachServiceStatus: string;
}
