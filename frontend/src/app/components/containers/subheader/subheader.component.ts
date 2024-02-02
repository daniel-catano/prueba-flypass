import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-subheader',
  templateUrl: './subheader.component.html',
  styleUrls: ['./subheader.component.sass']
})
export class SubheaderComponent {
  @Input()
  title: string = '' ;
  @Input()
  icon: string = '';

}
