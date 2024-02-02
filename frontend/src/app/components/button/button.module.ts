import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ButtonComponent} from "./button.component";
import {FabComponent} from "../fab/fab.component";
import {IconModule} from "../icon/icon.module";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  declarations: [
    ButtonComponent,
    FabComponent
  ],
  imports: [
    CommonModule,
    IconModule,
    MatButtonModule,
  ],
  exports: [
    ButtonComponent,
    FabComponent,
  ]
})
export class ButtonModule { }
