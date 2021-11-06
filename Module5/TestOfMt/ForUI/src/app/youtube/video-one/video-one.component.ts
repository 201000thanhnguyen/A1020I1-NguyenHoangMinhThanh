import { Component, OnInit } from '@angular/core';
import {trigger, style, transition, animate, keyframes, query, stagger, state} from '@angular/animations';

@Component({
  selector: 'app-video-one',
  templateUrl: './video-one.component.html',
  styleUrls: ['./video-one.component.css'],
  animations: [
    trigger('listAnimation', [
      transition('* => *', [

        query(':enter', style({ opacity: 0 }), {optional: true}),

        query(':enter', stagger('.3s', [
          animate('1s ease-in', keyframes([
              style({opacity: 0, transform: 'translateY(-75%)', offset: 0}),
              style({opacity: .5, transform: 'translateY(35px)', offset: 0.3}),
              style({opacity: 1, transform: 'translateY(0)', offset: 1.0}),
            ])
          ),
        ]), {optional: true}),

        query(':leave', stagger('300ms', [
          animate('1s ease-in', keyframes([
            style({opacity: 1, transform: 'translateY(0)', offset: 0}),
            style({opacity: .5, transform: 'translateY(35px)', offset: 0.3}),
            style({opacity: 0, transform: 'translateY(-75%)', offset: 1.0}),
          ]))]), {optional: true}),

      ]),
    ]),

    trigger('explainerAnim', [
      transition('* => *', [
        query('.gradually-left', style({ opacity: 0, transform: 'translateX(-40px)' })),

        query('.gradually-left', stagger('.5s', [
          animate('.8s 1.8s ease-out', style({ opacity: 1, transform: 'translateX(0)' })),
        ])),

        query('.gradually-left', [
          animate('1s', style('*'))
        ])

      ])
    ]),
    trigger(
      'fadeOne', [
        transition('void => *', [
          style({
            backgroundColor: 'yellow',
            color: 'red',
            opacity: 0
          }),
          animate(
            '1000ms 1s ease-out',
            style({
              backgroundColor: 'transparent',
              color: 'black',
              opacity: 1
            })
          )
        ]),
      ]
    ),
  ]
})
export class VideoOneComponent implements OnInit {

  items: any = [];

  constructor() {
    this.items = ['Hey this is an item', 'Here is another one','This is awesome'];
  }

  ngOnInit(): void {
  }

  pushItem() {
    this.items.push('Oh yeah that is awesome');
  }
  removeItem() {
    this.items.pop();
  }

}
