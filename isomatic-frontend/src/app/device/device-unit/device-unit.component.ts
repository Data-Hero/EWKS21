import {Component, OnInit} from '@angular/core';
import {DeviceControllerService, DeviceModelControllerService, DeviceUnitDto} from "../../shared/_generated/rest-api";
import {takeUntil, tap} from "rxjs/operators";

@Component({
  selector: 'app-device-unit',
  templateUrl: './device-unit.component.html',
  styleUrls: ['./device-unit.component.css']
})
export class DeviceUnitComponent implements OnInit {

  $devices = this.deviceController.getAllDevices()
  $models = this.deviceModelController.getAllDeviceModels()

  devices: Array<DeviceUnitDto> = []

  selectedModelIdentifier: string = ""

  constructor(private deviceController: DeviceControllerService, private deviceModelController: DeviceModelControllerService) { }

  ngOnInit(): void {
    this.$devices.subscribe(data => {
      this.devices = data
    })
  }

  public isDeviceRegistered(device: DeviceUnitDto): boolean {
    return device.registrationStatus?.status == "REGISTERED"
  }

  public deleteDevice(device: DeviceUnitDto) {
    const serialNumber = device.serialNumber?.serialNumber || ""
    console.log("delete: " + serialNumber)

    this.deviceController.deleteDevice(serialNumber).subscribe(() => {
      this.devices = this.devices.filter(value => value.serialNumber?.serialNumber !== serialNumber)
    })
  }

  public createDeviceFromSelectedModelIdentifier() {
    console.log("create: " + this.selectedModelIdentifier)
    this.deviceController.createDeviceByModelIdentifier(this.selectedModelIdentifier).subscribe(dto => {
      this.devices.push(dto)
    })
  }

  public registerDevice(device: DeviceUnitDto) {
    const serialNumber = device.serialNumber?.serialNumber || ""
    console.log("register: " + serialNumber)

    this.deviceController.registerDevice(serialNumber).subscribe(dto => {
      const index = this.devices.findIndex(value => value.serialNumber?.serialNumber == serialNumber)
      this.devices[index] = dto;
    })
  }

  public unregisterDevice(device: DeviceUnitDto) {
    const serialNumber = device.serialNumber?.serialNumber || ""
    console.log("unregister: " + serialNumber)

    this.deviceController.unregisterDevice(serialNumber).subscribe(dto => {
      const index = this.devices.findIndex(value => value.serialNumber?.serialNumber == serialNumber)
      this.devices[index] = dto;
    })
  }
}
