import {Component, Input} from '@angular/core';
import {ControlBase} from "../inputs/control-base";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-check-box',
  templateUrl: './check-box.component.html',
  styleUrls: ['./check-box.component.sass']
})
export class CheckBoxComponent {
  @Input() control!: ControlBase<string>;
  @Input() form!: FormGroup;
}
