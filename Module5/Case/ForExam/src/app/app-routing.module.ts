import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ForFuramaComponent} from "./for-furama/for-furama.component";

const routes: Routes = [
  {path: "", component: ForFuramaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
