import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingFunctionbundleComponent } from './booking-functionbundle.component';

describe('BookingFunctionbundleComponent', () => {
  let component: BookingFunctionbundleComponent;
  let fixture: ComponentFixture<BookingFunctionbundleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookingFunctionbundleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingFunctionbundleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
