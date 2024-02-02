import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LinearProgressComponent } from './linear-progress/linear-progress.component';
import {MatProgressBarModule} from "@angular/material/progress-bar";



@NgModule({
  declarations: [
    LinearProgressComponent
  ],
  exports: [
    LinearProgressComponent
  ],
  imports: [
    CommonModule,
    MatProgressBarModule
  ]
})
export class ProgressModule { }
