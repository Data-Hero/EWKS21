package de.joergiso.isomatic.device.exception;

import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DeviceAlreadyRegisteredException extends Exception {

    private final DeviceUnitSerialNumber serialNumber;

    public DeviceAlreadyRegisteredException(DeviceUnitSerialNumber serialNumber) {
        super("Gerät ist bereits registriert.");

        this.serialNumber = serialNumber;
    }

    public DeviceUnitSerialNumber getSerialNumber() {
        return serialNumber;
    }
}
