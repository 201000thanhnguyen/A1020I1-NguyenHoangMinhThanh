import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ImagesComponent } from './images/images.component';
import { ImageComponent } from './images/image/image.component';
import { ImageListComponent } from './images/image-list/image-list.component';
import {HttpClientModule} from "@angular/common/http";

import {AngularFireModule} from "@angular/fire/compat";
import {AngularFireStorageModule} from "@angular/fire/compat/storage";
import {AngularFireDatabaseModule} from "@angular/fire/compat/database";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    ImagesComponent,
    ImageComponent,
    ImageListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AngularFireModule.initializeApp({
      apiKey: "AIzaSyCyoDG4USpyALCHyP2Pz8m96qzMCWIVPjM",
      authDomain: "fir-image-ae5c6.firebaseapp.com",
      databaseURL: "https://fir-image-ae5c6-default-rtdb.firebaseio.com",
      projectId: "fir-image-ae5c6",
      storageBucket: "fir-image-ae5c6.appspot.com",
      messagingSenderId: "492857463213",
      appId: "1:492857463213:web:93f6d906e2bee87fe11124"
    }),
    AngularFireStorageModule,
    AngularFireDatabaseModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
