import { Component } from '@angular/core';
import {InformationMessages} from "../../../constants/informationMessages";

@Component({
  selector: 'app-empty-list',
  templateUrl: './empty-list.component.html',
  styleUrls: ['./empty-list.component.sass']
})
export class EmptyListComponent {
  text: string = InformationMessages.emptyList;
  icon: string = 'icn-notificacion-medium';

}
