export * from './booking-controller.service';
import { BookingControllerService } from './booking-controller.service';
export * from './device-controller.service';
import { DeviceControllerService } from './device-controller.service';
export * from './device-model-controller.service';
import { DeviceModelControllerService } from './device-model-controller.service';
export * from './user-controller.service';
import { UserControllerService } from './user-controller.service';
export const APIS = [BookingControllerService, DeviceControllerService, DeviceModelControllerService, UserControllerService];
