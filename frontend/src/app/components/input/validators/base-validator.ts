import {ValidatorFn} from "@angular/forms";

export class BaseValidator {
  validator: ValidatorFn;
  name: string;
  message: string;

  constructor(validator: ValidatorFn, name: string, message: string) {
    this.validator = validator;
    this.name = name;
    this.message = message;
  }
}
