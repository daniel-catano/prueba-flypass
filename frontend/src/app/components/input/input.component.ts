import {Component, Input} from '@angular/core';
import {ControlBase} from "./inputs/control-base";
import {FormControl, FormGroup, FormGroupDirective, NgForm} from "@angular/forms";
import {ErrorStateMatcher} from "@angular/material/core";
import {InputType} from "./enums/input-type";

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.sass']
})
export class InputComponent<Type extends ControlBase<string>> {
  @Input() control!: Type;
  @Input() form!: FormGroup;
  matcher = new MyErrorStateMatcher();
  inputType = InputType
  get isValid() {
    return this.form.controls[this.control.key].valid
  }
}
