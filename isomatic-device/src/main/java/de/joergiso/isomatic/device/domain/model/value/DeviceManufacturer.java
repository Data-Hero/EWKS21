package de.joergiso.isomatic.device.domain.model.value;

import java.io.Serializable;

public class DeviceManufacturer implements Serializable {
    public final String abbr;
    public final String name;

    public DeviceManufacturer(String abbr, String name) {
        this.abbr = abbr;
        this.name = name;
    }
}
