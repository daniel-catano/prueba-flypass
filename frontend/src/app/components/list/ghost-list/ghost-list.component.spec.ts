import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GhostListComponent } from './ghost-list.component';
import {ContainersModule} from "../../containers/containers.module";
import {IconModule} from "../../icon/icon.module";

describe('GhostListComponent', () => {
  let component: GhostListComponent;
  let fixture: ComponentFixture<GhostListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GhostListComponent ],
      imports: [ContainersModule, IconModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GhostListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
