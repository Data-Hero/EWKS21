package de.joergiso.isomatic.device.exception;

import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeviceNotFoundException extends Exception {
    private DeviceUnitSerialNumber serialNumber;

    public DeviceNotFoundException(DeviceUnitSerialNumber serialNumber) {
        super("Gerät nicht gefunden.");
        this.serialNumber = serialNumber;
    }

    public DeviceUnitSerialNumber getSerialNumber() {
        return serialNumber;
    }
}
