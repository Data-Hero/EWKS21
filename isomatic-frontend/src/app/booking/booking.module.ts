import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookingFunctionbundleComponent } from './booking-functionbundle/booking-functionbundle.component';
import { BookingComponent } from './booking.component';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';



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
    CommonModule,
    MatTableModule,
    MatButtonModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule
  ]
})
export class BookingModule { }
