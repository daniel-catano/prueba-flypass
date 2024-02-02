import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ButtonComponent } from './button.component';
import {IconModule} from "../icon/icon.module";
import {MatButtonModule} from "@angular/material/button";

describe('ButtonComponent', () => {
  let component: ButtonComponent;
  let fixture: ComponentFixture<ButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ButtonComponent ],
      imports: [IconModule, MatButtonModule,]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('Debería estar deshabilitado', () => {
    component.isDisabled = true;
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('button')?.attributes.getNamedItem('disabled')?.value).toBe('true');
  })
  it('Debería ser de tipo submit', () => {
    component.type = 'submit';
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('button')?.attributes.getNamedItem('type')?.value).toBe('submit');
  })
  it('Debería poner el texto en mayúscula', () => {
    component.text = 'text';
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('#button-text')?.innerHTML).toBe('TEXT');
  })
});
