import {Component, ElementRef, OnInit, Renderer2} from '@angular/core';
import {NgbDateStruct} from "@ng-bootstrap/ng-bootstrap";
import {NavigationEnd, Router} from "@angular/router";
import {Observable, Subscription} from "rxjs";
export declare function filter<T>(this: Observable<T>, predicate: (value: T, index: number) => boolean, thisArg?: any): Observable<T>;

@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }
}
