import {Component, Input} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {MyErrorStateMatcher} from "../input.component";
import {InputTextArea} from "../inputs/input-text-area";

@Component({
  selector: 'app-text-area',
  templateUrl: './text-area.component.html',
  styleUrls: ['./text-area.component.sass']
})
export class TextAreaComponent {
  @Input() control!: InputTextArea;
  @Input() form!: FormGroup;

  matcher = new MyErrorStateMatcher();
}
