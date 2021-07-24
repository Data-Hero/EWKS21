package de.joergiso.isomatic.device.util;

import de.joergiso.isomatic.device.domain.model.DeviceModelDto;
import de.joergiso.isomatic.device.domain.unit.DeviceUnitDto;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;

public class DeviceUnitFactory {

    public static DeviceUnitDto build(DeviceModelDto modelDto) {
        DeviceUnitSerialNumber serialNumber = DeviceUnitSerialNumberGenerator.generateDeviceUnitSerialNumber(modelDto);
        return new DeviceUnitDto(serialNumber, modelDto);
    }
}
