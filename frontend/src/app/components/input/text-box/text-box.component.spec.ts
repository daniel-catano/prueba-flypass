import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextBoxComponent } from './text-box.component';
import {MatInputModule} from "@angular/material/input";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {InputRadio} from "../inputs/input-radio";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

describe('TextBoxComponent', () => {
  let component: TextBoxComponent;
  let fixture: ComponentFixture<TextBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TextBoxComponent ],
      imports: [ MatInputModule, ReactiveFormsModule, BrowserAnimationsModule ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TextBoxComponent);
    component = fixture.componentInstance;
    component.form = new FormGroup({key:  new FormControl('')});
    component.control = new InputRadio({validations: [], label: '', key: 'key'});
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
