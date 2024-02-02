import {Component, Input} from '@angular/core';
import {ControlBase} from "../inputs/control-base";
import {FormGroup} from "@angular/forms";
import {MyErrorStateMatcher} from "../input.component";

@Component({
  selector: 'app-text-box',
  templateUrl: './text-box.component.html',
  styleUrls: ['./text-box.component.sass']
})
export class TextBoxComponent {
  @Input() control!: ControlBase<string>;
  @Input() form!: FormGroup;

  matcher = new MyErrorStateMatcher();
  hide = true;

  getType() {
    if(this.control.type === 'password' && this.hide) {
      return 'password'
    }
    if(this.control.type === 'password' && !this.hide) {
      return 'text'
    }
    return this.control.type
  }
}
