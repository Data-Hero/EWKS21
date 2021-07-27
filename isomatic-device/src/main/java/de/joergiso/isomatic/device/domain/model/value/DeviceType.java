package de.joergiso.isomatic.device.domain.model.value;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DeviceType implements Serializable {
    public String type;

    public DeviceType() {
        this.type = "";
    }

    public DeviceType(String type) {
        this.type = type;
    }
}
