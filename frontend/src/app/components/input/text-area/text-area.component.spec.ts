import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextAreaComponent } from './text-area.component';
import {MatInputModule} from "@angular/material/input";
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {InputTextArea} from "../inputs/input-text-area";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

describe('TextAreaComponent', () => {
  let component: TextAreaComponent;
  let fixture: ComponentFixture<TextAreaComponent>;
  const formBuilder: FormBuilder = new FormBuilder();
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TextAreaComponent ],
      imports: [ MatInputModule, ReactiveFormsModule, BrowserAnimationsModule ],
      providers: [ { provide: FormBuilder, useValue: formBuilder }]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TextAreaComponent);
    component = fixture.componentInstance;
    component.form = new FormGroup({key:  new FormControl('')});
    component.control = new InputTextArea({validations: [], label: '', key: 'key'});
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
