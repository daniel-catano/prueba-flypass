import {Component, Input} from '@angular/core';
import {ControlBase} from "../inputs/control-base";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-date-picker',
  templateUrl: './date-picker.component.html',
  styleUrls: ['./date-picker.component.sass']
})
export class DatePickerComponent {
  @Input() control!: ControlBase<string>;
  @Input() form!: FormGroup;
}
