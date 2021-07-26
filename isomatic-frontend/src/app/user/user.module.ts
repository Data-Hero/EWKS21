import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user.component';
import { AddDeviceComponent } from './add-device/add-device.component';
import { UserListComponent } from './user-list/user-list.component';
import {FormsModule} from "@angular/forms";



@NgModule({
  declarations: [
    UserComponent,
    AddDeviceComponent,
    UserListComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    UserComponent
  ]
})
export class UserModule { }
