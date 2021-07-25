import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DeviceUnitComponent } from './device-unit/device-unit.component';
import { DeviceModelComponent } from './device-model/device-model.component';



@NgModule({
  declarations: [
    DeviceUnitComponent,
    DeviceModelComponent
  ],
  exports: [
    DeviceUnitComponent,
    DeviceModelComponent
  ],
  imports: [
    CommonModule
  ]
})
export class DeviceModule { }
