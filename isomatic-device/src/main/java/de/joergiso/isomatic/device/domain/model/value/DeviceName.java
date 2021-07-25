package de.joergiso.isomatic.device.domain.model.value;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DeviceName implements Serializable {
    public final String name;

    public DeviceName() {
        this.name = "";
    }

    public DeviceName(String name) {
        this.name = name;
    }
}
