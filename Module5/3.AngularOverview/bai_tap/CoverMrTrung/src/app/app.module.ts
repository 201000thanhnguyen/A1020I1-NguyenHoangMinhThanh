import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponent } from './controllers/student/student.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { StudentListComponent } from './controllers/student-list/student-list.component';
import { StudentDetailComponent } from './controllers/student-detail/student-detail.component';
import {RouterModule} from "@angular/router";

// remember use tag <router-outlet> when use RouterModule | routing
@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    StudentListComponent,
    StudentDetailComponent,
  ],
  imports: [
    BrowserModule,

    // plan 1
    // use this AppRoutingModule there is no need to use plan 2
    AppRoutingModule,

    FormsModule,
    ReactiveFormsModule,

    // plan 2
    // if use plan 2 then remove AppRoutingModule
    // if it has both, it will still work
    // and the priority is the same
    // RouterModule.forRoot([
      // {path: '', component: StudentListComponent},
      // {path: 'students/:studentId', component: StudentDetailComponent},
    // ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
