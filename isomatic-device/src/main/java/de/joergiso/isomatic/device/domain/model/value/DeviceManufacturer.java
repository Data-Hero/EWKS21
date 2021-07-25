package de.joergiso.isomatic.device.domain.model.value;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DeviceManufacturer implements Serializable {
    @Column public final String manAbbr;
    @Column public final String manName;

    public DeviceManufacturer() {
        this.manAbbr = "";
        this.manName = "";
    }

    public DeviceManufacturer(String manAbbr, String manName) {
        this.manAbbr = manAbbr;
        this.manName = manName;
    }
}
