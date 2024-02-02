import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {InputComponent} from "./input.component";
import {TextBoxComponent} from "./text-box/text-box.component";
import {TextAreaComponent} from "./text-area/text-area.component";
import {SelectComponent} from "./select/select.component";
import {InputRadioComponent} from "./input-radio/input-radio.component";
import {CheckBoxComponent} from "./check-box/check-box.component";
import {DatePickerComponent} from "./date-picker/date-picker.component";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {MatRadioModule} from "@angular/material/radio";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";

@NgModule({
  declarations: [
    InputComponent,
    TextBoxComponent,
    TextAreaComponent,
    SelectComponent,
    InputRadioComponent,
    CheckBoxComponent,
    DatePickerComponent
  ],
  imports: [
    CommonModule,
    MatButtonModule,
    MatInputModule,
    MatSelectModule,
    MatRadioModule,
    MatCheckboxModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatIconModule,
  ],
  exports: [
    InputComponent,
    TextBoxComponent,
    TextAreaComponent,
    SelectComponent,
    InputRadioComponent,
    CheckBoxComponent,
    DatePickerComponent
  ]
})
export class InputModule { }
