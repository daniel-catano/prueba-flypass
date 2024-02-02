import {ControlBase} from "./control-base";
import {InputType} from "../enums/input-type";
import {BaseValidator} from "../validators/base-validator";

export class InputCheckBox extends ControlBase<string> {

  constructor(options: {
    value?: string;
    key?: string;
    label?: string;
    validations: BaseValidator[] | [];
    order?: number;
    type?: string;
    options?: { key: string; value: string }[],
    checked?: boolean}
  ) {
    super({...options, controlType: InputType.checkBox});
  }
}
