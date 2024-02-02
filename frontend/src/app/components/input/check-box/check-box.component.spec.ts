import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckBoxComponent } from './check-box.component';
import {MatCheckboxModule} from "@angular/material/checkbox";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {InputCheckBox} from "../inputs/input-check-box";

describe('CheckBoxComponent', () => {
  let component: CheckBoxComponent;
  let fixture: ComponentFixture<CheckBoxComponent>;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckBoxComponent ],
      imports: [MatCheckboxModule, ReactiveFormsModule, ReactiveFormsModule],
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckBoxComponent);
    component = fixture.componentInstance;
    component.form = new FormGroup({key:  new FormControl('')});
    component.control = new InputCheckBox({validations: [], label: '', key: 'key'});
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
