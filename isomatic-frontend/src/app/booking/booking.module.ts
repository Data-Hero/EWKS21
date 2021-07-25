import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookingFunctionbundleComponent } from './booking-functionbundle/booking-functionbundle.component';
import { BookingComponent } from './booking.component';



@NgModule({
  declarations: [
    BookingFunctionbundleComponent,
    BookingComponent
  ],
  exports: [
    BookingFunctionbundleComponent,
    BookingComponent
  ],
  imports: [
    CommonModule
  ]
})
export class BookingModule { }
