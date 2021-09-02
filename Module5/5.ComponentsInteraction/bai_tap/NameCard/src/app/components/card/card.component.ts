import {Component, Input, OnInit} from '@angular/core';
import {InfoCard} from "../../info-card";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input() infoCardChild!: InfoCard;

  @Input() backgroundColor: string = '#d9d9d9';
  @Input() progressColor: string = '#4CAF50';
  @Input() width: number = 0;
  height: number = 50;

  constructor() { }

  ngOnInit(): void {
    if (this.width > 100){
      this.width = 100;
    }else if (this.width < 0){
      this.width = 0;
    }
  }

}
