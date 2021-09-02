import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ContentComponent} from "./layout/content/content.component";
import {RoomsComponent} from "./rooms/rooms.component";

const routes: Routes = [
  {path: '', component: ContentComponent},
  {path: 'rooms',component: RoomsComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
