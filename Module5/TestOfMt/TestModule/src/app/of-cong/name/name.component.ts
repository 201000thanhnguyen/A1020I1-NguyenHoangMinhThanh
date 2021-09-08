import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-name',
  templateUrl: './name.component.html',
  styleUrls: ['./name.component.css']
})
export class NameComponent implements OnInit {

  @Input() scoreOfCong: any;
  @Output() eventOfCong = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
    // c1
    Promise.resolve().then(() => this.eventOfCong.emit('cong day'));

    // c2
    // this.eventOfCong.emit('cong day');
  }

}
