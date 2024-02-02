import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ContainerComponent} from "./container/container.component";
import {HeaderComponent} from "./header/header.component";
import {SubheaderComponent} from "./subheader/subheader.component";

@NgModule({
  declarations: [
    ContainerComponent,
    HeaderComponent,
    SubheaderComponent,
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ContainerComponent,
    HeaderComponent,
    SubheaderComponent,
  ]
})
export class ContainersModule { }
