import {Component, OnInit} from '@angular/core';
import {
  CreateDeviceModelRequest, DeviceControllerService,
  DeviceFunctionBlueprint,
  DeviceModelControllerService,
  DeviceModelDto, DeviceUnitDto
} from "../../shared/_generated/rest-api";
import {tap} from "rxjs/operators";

@Component({
  selector: 'app-device-model',
  templateUrl: './device-model.component.html',
  styleUrls: ['./device-model.component.css']
})
export class DeviceModelComponent implements OnInit {

  $devices = this.deviceController.getAllDevices()
  devices: Array<DeviceUnitDto> = []

  $models = this.deviceModelController.getAllDeviceModels()
  models: Array<DeviceModelDto> = []

  newDeviceModel: CreateDeviceModelRequest = {};
  functionBlueprints: Array<DeviceFunctionBlueprint> = []

  constructor(private deviceController: DeviceControllerService, private deviceModelController: DeviceModelControllerService) { }

  ngOnInit(): void {
    this.$devices.subscribe(data => this.devices = data)
    this.$models.subscribe(data => this.models = data)
  }

  getEuroFromCent(cent?: number): number {
    return (cent || 0) / 100;
  }

  isDeletable(model: DeviceModelDto): boolean {
    if (model.identifier?.identifier === undefined) return true
    else {
      const identifier = model.identifier.identifier
      return !this.devices.find(value => value.modelDto?.identifier?.identifier === identifier)
    }
  }

  isPerUse(usage?: string): boolean {
    return usage ? usage == "PER_USE" : false
  }

  addFunctionBlueprint() {
    this.functionBlueprints.push({ name: "", price: 0, amount: 0, usage: "PER_MINUTE" })
  }

  deleteFunctionBlueprintByIndex(bpIndex: number) {
    this.functionBlueprints = this.functionBlueprints.filter((value, index) => index !== bpIndex)
  }

  createDeviceModel() {
    console.log("create: " + this.newDeviceModel)

    this.newDeviceModel.manufacturerAbbr = this.newDeviceModel.manufacturerAbbr || "XXX"
    this.newDeviceModel.functionBlueprints = this.functionBlueprints
    this.deviceModelController.createDeviceModel(this.newDeviceModel).subscribe(data => {
      console.log("created: " + data)
      this.models.push(data)

      this.newDeviceModel = {}
      this.functionBlueprints = []
    })
  }

  deleteDeviceModel(model: DeviceModelDto) {
    const identifier = model.identifier?.identifier || ""
    console.log("delete: " + identifier)

    this.deviceModelController.deleteDeviceModel(identifier).subscribe(() => {
      console.log("deleted: " + identifier)
      this.models = this.models.filter(value => value.identifier?.identifier !== identifier)
    })
  }

}
