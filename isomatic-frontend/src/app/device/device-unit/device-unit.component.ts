import {Component, OnInit} from '@angular/core';
import {DeviceControllerService, DeviceModelControllerService, DeviceUnitDto} from "../../shared/_generated/rest-api";
import {takeUntil, tap} from "rxjs/operators";

@Component({
  selector: 'app-device-unit',
  templateUrl: './device-unit.component.html',
  styleUrls: ['./device-unit.component.css']
})
export class DeviceUnitComponent implements OnInit {

  $devices = this.deviceController.getAllDevices().pipe(tap(

  ))
  $models = this.deviceModelController.getAllDeviceModels()

  devices: Array<DeviceUnitDto> = []

  selectedModel: string = ""

  constructor(private deviceController: DeviceControllerService, private deviceModelController: DeviceModelControllerService) { }

  ngOnInit(): void {
    this.$devices.subscribe(data => {
      this.devices = data
    })
  }

  public deleteDeviceBySerialNumber(serialNumber: string) {
  }

  public createDeviceFromSelectedModelIdentifier() {
    console.log("create")
    this.deviceController.createDeviceByModelIdentifier(this.selectedModel).subscribe(dto => {
      this.devices.push(dto)
      console.log(dto)
    })
  }


}
