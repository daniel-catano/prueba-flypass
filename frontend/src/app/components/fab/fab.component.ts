import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-fab',
  templateUrl: './fab.component.html',
  styleUrls: ['./fab.component.sass']
})
export class FabComponent {
  @Input()
  material: boolean = false;
  @Input()
  icon: string | undefined;
  @Input()
  text: string | undefined;
  @Output() btnClick = new EventEmitter();

  onClick() {
    this.btnClick.emit();
  }
}
