import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {GhostListComponent} from "./ghost-list/ghost-list.component";
import {ContainersModule} from "../containers/containers.module";
import {IconModule} from "../icon/icon.module";
import { EmptyListComponent } from './empty-list/empty-list.component';



@NgModule({
  declarations: [GhostListComponent, EmptyListComponent],
  imports: [
    CommonModule,
    ContainersModule,
    IconModule,
  ],
    exports: [GhostListComponent, EmptyListComponent]
})
export class ListModule { }
