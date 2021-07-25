package de.joergiso.isomatic.device.util;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.unit.DeviceUnit;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitRegistrationStatus;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;

public class DeviceUnitFactory {

    public static DeviceUnit build(DeviceModel model) {
        DeviceUnitSerialNumber serialNumber = DeviceUnitSerialNumberGenerator.generateDeviceUnitSerialNumber(model);
        return new DeviceUnit(serialNumber, model, new DeviceUnitRegistrationStatus());
    }
}
