import { Component, OnInit } from '@angular/core';
import {animate, keyframes, state, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-one',
  templateUrl: './one.component.html',
  styleUrls: ['./one.component.css'],
  animations: [
    trigger(
      'openClose', [
        state(
          'open', style({
            height: '200px',
            opacity: 1,
            backgroundColor: 'yellow'
          })
        ),
        state(
          'closed', style({
            height: '100px',
            opacity: 0.5,
            backgroundColor: '#c6ecff'
          })
        ),

        transition(':enter', [
          animate('1s')
        ]),

        transition('open => closed', [
          animate('1s')
        ]),

        transition('closed => open', [
          animate('0.5s')
        ])
      ]
    ),
    trigger(
      'scaleBtn', [
        transition(':enter', [
          animate('0.7s ease-in', keyframes([
            style({opacity: 1, transform: 'scale(1)'}),
            style({opacity: 0.5, transform: 'scale(1.3)'}),
            style({opacity: 1, transform: 'scale(1)'}),
          ]))
        ])
      ]
    )
  ]
})

export class OneComponent implements OnInit {

  isOpen: boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  toggle(){
    this.isOpen = !this.isOpen;
  }

}
