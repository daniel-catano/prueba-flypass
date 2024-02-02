import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputRadioComponent } from './input-radio.component';
import {MatRadioModule} from "@angular/material/radio";
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {InputRadio} from "../inputs/input-radio";

describe('InputRadioComponent', () => {
  let component: InputRadioComponent;
  let fixture: ComponentFixture<InputRadioComponent>;
  const formBuilder: FormBuilder = new FormBuilder();
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InputRadioComponent ],
      imports: [MatRadioModule, ReactiveFormsModule],
      providers: [ { provide: FormBuilder, useValue: formBuilder }]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InputRadioComponent);
    component = fixture.componentInstance;
    component.form = new FormGroup({key:  new FormControl('')});
    component.control = new InputRadio({validations: [], label: '', key: 'key'});
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
