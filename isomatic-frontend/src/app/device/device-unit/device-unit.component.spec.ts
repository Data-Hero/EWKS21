import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeviceUnitComponent } from './device-unit.component';

describe('DeviceUnitComponent', () => {
  let component: DeviceUnitComponent;
  let fixture: ComponentFixture<DeviceUnitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeviceUnitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeviceUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
