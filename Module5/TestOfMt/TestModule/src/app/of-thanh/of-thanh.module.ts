import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ScoreComponent } from './score/score.component';
import { InfoComponent } from './info/info.component';
import {OfCongModule} from "../of-cong/of-cong.module";



@NgModule({
  declarations: [
    ScoreComponent,
    InfoComponent
  ],
  exports: [
    ScoreComponent
  ],
  imports: [
    CommonModule,
    OfCongModule
  ]
})
export class OfThanhModule { }
