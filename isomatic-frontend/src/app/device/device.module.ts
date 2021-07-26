import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DeviceUnitComponent} from './device-unit/device-unit.component';
import {DeviceModelComponent} from './device-model/device-model.component';
import {MatSelectModule} from "@angular/material/select";
import {FormsModule} from "@angular/forms";


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
    CommonModule,
    MatSelectModule,
    FormsModule
  ]
})
export class DeviceModule { }
