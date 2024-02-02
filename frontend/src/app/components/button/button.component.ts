import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.sass']
})
export class ButtonComponent {
  buttonText = '';
  @Input()
  set text(name: string) {
    this.buttonText = name.toUpperCase();
  }

  get name(): string {
    return this.buttonText;
  }

  @Input() color: string = 'primary';
  @Input() type: string = 'button';
  @Input() isDisabled = false;
  @Output() btnClick = new EventEmitter();

  onClick() {
    this.btnClick.emit();
  }
}
