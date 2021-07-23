package de.joergiso.isomatic.device.util;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.unit.DeviceUnitDto;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;

public class DeviceUnitFactory {

    public static DeviceUnitDto build(DeviceModel model) {
        DeviceUnitSerialNumber serialNumber = DeviceUnitSerialNumberGenerator.generateDeviceUnitSerialNumber(model);
        return new DeviceUnitDto(serialNumber, model);
    }
}
