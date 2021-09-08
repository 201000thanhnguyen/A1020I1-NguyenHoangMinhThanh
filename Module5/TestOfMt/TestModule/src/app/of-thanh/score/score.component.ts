import {AfterContentChecked, AfterViewInit, ChangeDetectorRef, Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-score',
  templateUrl: './score.component.html',
  styleUrls: ['./score.component.css']
})
export class ScoreComponent implements OnInit {

  scoreOfThanh: number = 10;
  whatFromCong!: string ;

  // c2
  constructor(private changeDetectorRef: ChangeDetectorRef) { }

  ngOnInit(): void {
  }

  // c2
  // ngAfterContentChecked(): void {
  //   this.changeDetectorRef.detectChanges();
  // }

  getEventFromCong(whatThat: any){
    this.whatFromCong = whatThat;
  }

}
