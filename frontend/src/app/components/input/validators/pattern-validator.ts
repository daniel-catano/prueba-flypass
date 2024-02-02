import {BaseValidator} from "./base-validator";
import {Validators} from "@angular/forms";

export class PatternValidator extends BaseValidator {

  constructor(pattern: string | RegExp, message?: string) {
    super(Validators.pattern(pattern), 'pattern', message??'El campo no cumple con el patrón.');
  }
}
