import {ControlBase} from "./control-base";
import {InputType} from "../enums/input-type";
import {BaseValidator} from "../validators/base-validator";

export class InputColor extends ControlBase<string> {
  constructor(options: {
    value?: string;
    key?: string;
    label?: string;
    validations?: BaseValidator[] | [];
    order?: number;
    type?: string;
    options?: { key: string; value: string }[] }
  ) {
    super({...options, controlType: InputType.color});
  }
}
