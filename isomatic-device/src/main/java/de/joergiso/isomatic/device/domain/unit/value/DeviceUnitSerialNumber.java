package de.joergiso.isomatic.device.domain.unit.value;

import java.io.Serializable;

public class DeviceUnitSerialNumber implements Serializable {
    public final String value;

    public DeviceUnitSerialNumber(String value) {
        this.value = value;
    }
}
