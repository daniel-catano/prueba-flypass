import {ControlBase} from "./control-base";
import {InputType} from "../enums/input-type";
import {BaseValidator} from "../validators/base-validator";

export class InputTextArea extends ControlBase<string> {
  rows: number;
  constructor(options: {
    value?: string;
    key?: string;
    label?: string;
    validations?: BaseValidator[] | [];
    order?: number;
    type?: string;
    options?: { key: string; value: string }[],
    rows?: number
  }) {
    super({...options, controlType: InputType.textArea});
    this.rows = options.rows??2;
  }
}
