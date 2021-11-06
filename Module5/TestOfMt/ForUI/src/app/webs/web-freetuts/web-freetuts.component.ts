import { Component, OnInit } from '@angular/core';
import {animate, state, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-web-freetuts',
  templateUrl: './web-freetuts.component.html',
  styleUrls: ['./web-freetuts.component.css'],
  animations: [
    trigger('myanimation', [
      state('smaller', style({
        transform: 'translateY(100px)'
      })),
      state('larger', style({
        transform: 'translateY(0px)'
      })),
      transition('smaller <=> larger', animate('300ms ease-in'))
    ])
  ]
})
export class WebFreetutsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  state: string = "smaller";
  animate() {
    this.state = this.state == 'larger' ? 'smaller' : 'larger';
  }

}
