import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VideoOneComponent } from './video-one/video-one.component';
import {RouterModule} from "@angular/router";



@NgModule({
  declarations: [
    VideoOneComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot([
      {path: 'video-one', component: VideoOneComponent}
    ])
  ]
})
export class YoutubeModule { }
