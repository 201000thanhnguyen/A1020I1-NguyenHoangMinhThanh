import {IServiceType} from "./service-type";
import {IRentType} from "./rent-type";

export class Service implements IService{
  rentType: IRentType;
  serviceArea: number;
  serviceCost: number;
  serviceDescriptionOtherConvenience: string;
  serviceId: number;
  serviceMaxPeople: number;
  serviceName: string;
  serviceNumberOfFloor: number;
  servicePoolArea: number;
  serviceStandardRoom: string;
  serviceType: IServiceType;
  urlImage: string;


  constructor(rentType: IRentType, serviceArea: number, serviceCost: number, serviceDescriptionOtherConvenience: string, serviceId: number, serviceMaxPeople: number, serviceName: string, serviceNumberOfFloor: number, servicePoolArea: number, serviceStandardRoom: string, serviceType: IServiceType, urlImage: string) {
    this.rentType = rentType;
    this.serviceArea = serviceArea;
    this.serviceCost = serviceCost;
    this.serviceDescriptionOtherConvenience = serviceDescriptionOtherConvenience;
    this.serviceId = serviceId;
    this.serviceMaxPeople = serviceMaxPeople;
    this.serviceName = serviceName;
    this.serviceNumberOfFloor = serviceNumberOfFloor;
    this.servicePoolArea = servicePoolArea;
    this.serviceStandardRoom = serviceStandardRoom;
    this.serviceType = serviceType;
    this.urlImage = urlImage;
  }
}

export interface IService {
  serviceId: number;
  serviceName: string;
  serviceArea: number;
  serviceCost: number;
  serviceMaxPeople: number;
  serviceStandardRoom: string;
  serviceDescriptionOtherConvenience: string;
  servicePoolArea: number;
  serviceNumberOfFloor: number;
  urlImage: string;

  serviceType: IServiceType;
  rentType: IRentType;
}
