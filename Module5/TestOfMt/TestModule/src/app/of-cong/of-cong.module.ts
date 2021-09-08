import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NameComponent } from './name/name.component';
import { AgeComponent } from './age/age.component';



@NgModule({
    declarations: [
        NameComponent,
        AgeComponent
    ],
    exports: [
        NameComponent
    ],
    imports: [
        CommonModule
    ]
})
export class OfCongModule { }
