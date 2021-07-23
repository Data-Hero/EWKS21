package de.joergiso.isomatic.device.util;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;

import java.time.Instant;

public class DeviceUnitSerialNumberGenerator {

    public static DeviceUnitSerialNumber generateDeviceUnitSerialNumber(DeviceModel model) {
        String abbr = model.getManufacturer().abbr;
        long millis = Instant.now().toEpochMilli();

        return new DeviceUnitSerialNumber(abbr + millis);
    }
}
