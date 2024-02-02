import {Component, Input} from '@angular/core';
import {ControlBase} from "../inputs/control-base";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-input-radio',
  templateUrl: './input-radio.component.html',
  styleUrls: ['./input-radio.component.sass']
})
export class InputRadioComponent {
  @Input() control!: ControlBase<string>;
  @Input() form!: FormGroup;
}
