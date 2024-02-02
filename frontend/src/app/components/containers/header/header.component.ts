import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.sass']
})
export class HeaderComponent {
  @Input()
  extended: boolean = false;
  @Input()
  icon: string | undefined;
  @Input()
  subtitle: string | undefined;
  @Input()
  title: string | undefined;
}
