import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';


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


  constructor() { }

  ngOnInit(): void {
  }

}
