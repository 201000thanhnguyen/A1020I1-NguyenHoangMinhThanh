import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardComponent } from './components/card/card.component';
import { CardCreateComponent } from './components/card-create/card-create.component';
import {FormsModule} from "@angular/forms";
import {RatingBarComponent} from "./components/rating-bar/rating-bar.component";
import {CountdownTimerAliasComponent} from "./components/countdown-timer-alias/countdown-timer-alias.component";
import {CountdownTimerComponent} from "./components/countdown-timer/countdown-timer.component";
import {CountdownTimerEventAliasComponent} from "./components/countdown-timer-event-alias/countdown-timer-event-alias.component";
import {CountdownTimerEventComponent} from "./components/countdown-timer-event/countdown-timer-event.component";
import {CountdownTimerGetSetComponent} from "./components/countdown-timer-get-set/countdown-timer-get-set.component";
import {CountdownTimerOnchangesComponent} from "./components/countdown-timer-onchanges/countdown-timer-onchanges.component";

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    CardCreateComponent,
    RatingBarComponent,
    CountdownTimerAliasComponent,
    CountdownTimerComponent,
    CountdownTimerEventAliasComponent,
    CountdownTimerEventComponent,
    CountdownTimerGetSetComponent,
    CountdownTimerOnchangesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
