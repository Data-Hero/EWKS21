package de.joergiso.isomatic.device.domain.model.value;

import java.io.Serializable;

public class DeviceName implements Serializable {
    public final String value;

    public DeviceName(String value) {
        this.value = value;
    }
}
