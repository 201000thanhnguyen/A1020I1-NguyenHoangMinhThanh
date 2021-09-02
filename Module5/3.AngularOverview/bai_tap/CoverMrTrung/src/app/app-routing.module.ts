import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentListComponent} from "./controllers/student-list/student-list.component";
import {StudentDetailComponent} from "./controllers/student-detail/student-detail.component";

const routes: Routes = [
  {path: '', component: StudentListComponent},
  {path: 'students/:studentId', component: StudentDetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
