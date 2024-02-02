import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LinearProgressComponent } from './linear-progress.component';
import {MatProgressBarModule} from "@angular/material/progress-bar";

describe('LinearProgressComponent', () => {
  let component: LinearProgressComponent;
  let fixture: ComponentFixture<LinearProgressComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LinearProgressComponent ],
      imports: [ MatProgressBarModule ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LinearProgressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('Debería mostrar el mensaje recibido', () => {
    component.message = 'message';
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('#message')?.innerHTML).toBe('message');
  })
});
