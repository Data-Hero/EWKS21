package de.joergiso.isomatic.device.domain.model.value;

import java.io.Serializable;

public class DeviceType implements Serializable {
    public final String value;

    public DeviceType(String value) {
        this.value = value;
    }
}
