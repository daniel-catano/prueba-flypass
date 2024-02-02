import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatePickerComponent } from './date-picker.component';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {InputDatePicker} from "../inputs/input-date-picker";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

describe('DatePickerComponent', () => {
  let component: DatePickerComponent;
  let fixture: ComponentFixture<DatePickerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatePickerComponent ],
      imports: [ReactiveFormsModule, MatInputModule, MatDatepickerModule, MatNativeDateModule, BrowserAnimationsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DatePickerComponent);
    component = fixture.componentInstance;
    component.form = new FormGroup({key:  new FormControl('')});
    component.control = new InputDatePicker({validations: [], label: '', key: 'key'});
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
