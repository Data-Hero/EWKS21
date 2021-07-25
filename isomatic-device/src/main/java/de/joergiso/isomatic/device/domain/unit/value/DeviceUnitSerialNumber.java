package de.joergiso.isomatic.device.domain.unit.value;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DeviceUnitSerialNumber implements Serializable {
    public final String serialNumber;

    public DeviceUnitSerialNumber() {
        this.serialNumber = "";
    }

    public DeviceUnitSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
