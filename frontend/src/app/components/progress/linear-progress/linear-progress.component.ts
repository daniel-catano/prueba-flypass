import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-linear-progress',
  templateUrl: './linear-progress.component.html',
  styleUrls: ['./linear-progress.component.sass']
})
export class LinearProgressComponent {
  @Input()
  message?: string;
}
