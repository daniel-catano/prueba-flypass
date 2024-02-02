import {Component, Input} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {MyErrorStateMatcher} from "../input.component";
import {InputSelect} from "../inputs/input-select";

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.sass']
})
export class SelectComponent {
  @Input() control!: InputSelect;
  @Input() form!: FormGroup;

  matcher = new MyErrorStateMatcher();
}
