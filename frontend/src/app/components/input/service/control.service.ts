import { Injectable } from '@angular/core';
import {ControlBase} from "../inputs/control-base";
import {FormControl, FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class ControlService {
  toFormGroup(controls: ControlBase<string>[]) {
    const group: any = {};
    controls.forEach(control => {
      group[control.key] = new FormControl(control.value || '', control.validations?.map(i => i.validator))
    })
    return new FormGroup(group);
  }

  constructor() { }
}
