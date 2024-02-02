import {BaseValidator} from "./base-validator";
import {Validators} from "@angular/forms";

export class EmailValidator extends BaseValidator {

  constructor(message?: string) {
    super(Validators.email, 'email', message??'El campo debe ser un correo.');
  }
}
