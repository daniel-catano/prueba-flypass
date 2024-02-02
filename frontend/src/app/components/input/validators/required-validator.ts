import {BaseValidator} from "./base-validator";
import {Validators} from "@angular/forms";

export class RequiredValidator extends BaseValidator {

  constructor(message?: string) {
    super(Validators.required, 'required', message??'Campo requerido.');
  }
}
