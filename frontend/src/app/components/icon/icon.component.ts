import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-icon',
  templateUrl: './icon.component.html',
  styleUrls: ['./icon.component.sass']
})
export class IconComponent {
  @Input()
  icon: string | undefined;

  @Input()
  material: boolean = true;
}
