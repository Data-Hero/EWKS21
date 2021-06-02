package de.joergiso.isomatic.device.domain.unit.value;

import java.io.Serializable;

public class DeviceUnitRegistrationStatus implements Serializable {
    public final Type type;

    public DeviceUnitRegistrationStatus(Type type) {
        this.type = type;
    }


    public enum Type {
        UNREGISTERED, REGISTERED;
    }
}
