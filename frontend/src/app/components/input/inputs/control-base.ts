import {InputType} from "../enums/input-type";
import {BaseValidator} from "../validators/base-validator";

export class ControlBase<T> {
  value: T | undefined;
  key: string;
  label: string;
  validations?: BaseValidator[] | [];
  order: number;
  controlType: InputType;
  type: string;
  options: { key: string, value: string }[];
  checked?: boolean
  icon: string;

  constructor(options: {
    value?: T;
    key?: string;
    label?: string;
    validations?: BaseValidator[] | [];
    order?: number;
    controlType: InputType;
    type?: string;
    options?: {key: string, value: string}[];
    checked?: boolean
    icon?: string
  }) {
    this.value = options.value;
    this.key = options.key || '';
    this.label = options.label || '';
    this.validations = options.validations;
    this.order = options.order === undefined ? 1 : options.order;
    this.controlType = options.controlType;
    this.type = options.type || '';
    this.options = options.options || [];
    this.checked = options.checked || false;
    this.icon = options.icon || '';
  }
}
