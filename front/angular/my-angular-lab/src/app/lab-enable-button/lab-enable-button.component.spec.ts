import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LabEnableButtonComponent } from './lab-enable-button.component';

describe('LabEnableButtonComponent', () => {
  let component: LabEnableButtonComponent;
  let fixture: ComponentFixture<LabEnableButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LabEnableButtonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LabEnableButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
