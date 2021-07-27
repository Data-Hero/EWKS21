import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DeviceUnitComponent} from "./device/device-unit/device-unit.component";
import {DeviceModelComponent} from "./device/device-model/device-model.component";
import {BookingComponent} from "./booking/booking.component";
import {BookingFunctionbundleComponent} from "./booking/booking-functionbundle/booking-functionbundle.component";
import {UserComponent} from "./user/user.component";

const routes: Routes = [
  { path: "", redirectTo: "/devices", pathMatch: "full" },
  { path: "devices", component: DeviceUnitComponent },
  { path: "models", component: DeviceModelComponent },
  { path: "users", component: UserComponent },
  { path: "bookings", component: BookingComponent },
  { path: "function-bundles", component: BookingFunctionbundleComponent },
  // { path: "users", component:  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    relativeLinkResolution: 'legacy',
    onSameUrlNavigation: 'reload'
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
