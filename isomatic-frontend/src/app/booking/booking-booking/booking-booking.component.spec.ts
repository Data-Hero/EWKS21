import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingBookingComponent } from './booking-booking.component';

describe('BookingBookingComponent', () => {
  let component: BookingBookingComponent;
  let fixture: ComponentFixture<BookingBookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookingBookingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookingBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
