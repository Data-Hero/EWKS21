import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {FormControl, FormGroup} from '@angular/forms';
import {FunctionBundle} from '../booking-functionbundle/booking-functionbundle.component';
import {BookingControllerService} from '../../shared/_generated/rest-api';


export interface Booking {
  userId: number;
  functionBundleId: string;
  startTime : string;
  endTime: string;
}

const ELEMENTS: Booking[] = [];


@Component({
  selector: 'app-booking-booking',
  templateUrl: './booking-booking.component.html',
  styleUrls: ['./booking-booking.component.css']
})
export class BookingBookingComponent implements OnInit {

  displayedColumns: string[] = ['userId', 'functionBundleId', 'startTime', 'endTime'];
  dataSource: MatTableDataSource<Booking> = new MatTableDataSource(ELEMENTS);
  uploadForm: FormGroup;
  addBookingForm: FormGroup;
  addBookingFormToggle: boolean = false;

  constructor(private bookingControllerService: BookingControllerService,
              private changeDetectorRefs: ChangeDetectorRef) {
    this.uploadForm = new FormGroup({
      UserId: new FormControl()
    });
    this.addBookingForm = new FormGroup({
      UserId: new FormControl(),
      FunctionBundleId: new FormControl(),
      StartTime: new FormControl(),
      EndTime: new FormControl()
    });
  }

  ngOnInit(): void {
    this.bookingControllerService.getAllBookings("body")
      .subscribe(value => {
        let response: Booking[] = [];
        value.forEach(element => {
          console.log(element.userId);
          response.push({
            userId: element.userId!,
            functionBundleId: element.functionBundleId!,
            startTime: element.startTime!,
            endTime: element.endTime!
            }
          );
          this.dataSource.data = response;
        })
        this.changeDetectorRefs.detectChanges();
      });
  }

  onSubmit(): void {
    const formData = new FormData();
    this.dataSource.data = [];
    // @ts-ignore
    this.bookingControllerService.getBookingsForUser(this.uploadForm.get('UserId').value,"body")
      .subscribe(value => {
        let response: Booking[] = [];
        value.forEach(element => {
          console.log(element.userId);
          response.push({
              userId: element.userId!,
              functionBundleId: element.functionBundleId!,
              startTime: element.startTime!,
              endTime: element.endTime!
            }
          );
          this.dataSource.data = response;
        })
        this.changeDetectorRefs.detectChanges();
      });
  }

  showAddBookingForm() {
    this.addBookingFormToggle = true;
  }

  hideAddBookingForm() {
    this.addBookingFormToggle = false;
  }

  onCreate() {

  }
}
