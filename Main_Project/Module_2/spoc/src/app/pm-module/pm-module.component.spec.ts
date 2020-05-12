import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PmModuleComponent } from './pm-module.component';

describe('PmModuleComponent', () => {
  let component: PmModuleComponent;
  let fixture: ComponentFixture<PmModuleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PmModuleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PmModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
