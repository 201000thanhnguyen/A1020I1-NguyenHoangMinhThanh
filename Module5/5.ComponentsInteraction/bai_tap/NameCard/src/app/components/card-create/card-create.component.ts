import { Component, OnInit } from '@angular/core';
import {InfoCard, cardDemo} from "../../info-card";

@Component({
  selector: 'app-card-create',
  templateUrl: './card-create.component.html',
  styleUrls: ['./card-create.component.css']
})
export class CardCreateComponent implements OnInit {

  infoCardParent!: InfoCard;
  infoCardDemo: InfoCard = cardDemo;
  width: number = 0;

  constructor() { }

  ngOnInit(): void {

  }

  getCardNameFromFormParent(value: string): void{
    this.infoCardDemo.cardName = value;
  }

  getEmailFromFormParent(value: string): void{
    this.infoCardDemo.email = value;
  }

  getPhoneFromFormParent(value: string): void{
    this.infoCardDemo.phone = value;
  }

  submitAddCard(): void{
    if (
      this.infoCardDemo.cardName == '' &&
      this.infoCardDemo.email == '' &&
      this.infoCardDemo.phone == ''
    ){
      console.log(`wrong`);
    }else {
      this.infoCardParent = this.infoCardDemo;
    }
  }

}
