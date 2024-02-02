import { TestBed } from '@angular/core/testing';

import { ControlService } from './control.service';
import {InputText} from "../inputs/input-text";
import {RequiredValidator} from "../validators/required-validator";

describe('ControlService', () => {
  let service: ControlService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ControlService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('Should build a FormGroup', () => {
    const controls = [new InputText({ key: 'name', label: 'Nombre', type: 'text', order: 1, validations: [new RequiredValidator()]})];
    expect(service.toFormGroup(controls).controls['name']).toBeDefined();
  });
});
