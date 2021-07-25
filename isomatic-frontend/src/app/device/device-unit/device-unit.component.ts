import { Component, OnInit } from '@angular/core';
import {DeviceControllerService} from "../../shared/_generated/rest-api/api/device-controller.service";

@Component({
  selector: 'app-device-unit',
  templateUrl: './device-unit.component.html',
  styleUrls: ['./device-unit.component.css']
})
export class DeviceUnitComponent implements OnInit {

  constructor(private deviceControllerService: DeviceControllerService) { }

  ngOnInit(): void {
  }

}
