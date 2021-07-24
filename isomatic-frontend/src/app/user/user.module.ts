import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user.component';
import { AddDeviceComponent } from './add-device/add-device.component';



@NgModule({
  declarations: [
    UserComponent,
    AddDeviceComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    UserComponent
  ]
})
export class UserModule { }
