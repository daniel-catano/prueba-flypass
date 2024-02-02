import {BaseValidator} from "./base-validator";
import {Validators} from "@angular/forms";

export class MinLengthValidator extends BaseValidator {

  constructor(minLength: number, message?: string) {
    super(Validators.minLength(minLength), 'minlength', message??'La longitud del campo es menor a lo esperado.');
  }
}
