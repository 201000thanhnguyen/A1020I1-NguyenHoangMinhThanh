import {AfterContentChecked, AfterViewInit, Component, DoCheck, OnInit, ViewEncapsulation} from '@angular/core';
declare function mainJs(): any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {

  title = 'Furama';

  ngOnInit(): void {
    mainJs();
  }

  constructor() {

  }

}
