package de.joergiso.isomatic.device.domain.model.value;

import javax.persistence.Embeddable;

@Embeddable
public class DeviceModelIdentifier {
    public final String identifier;

    public DeviceModelIdentifier() {
        identifier = "";
    }

    public DeviceModelIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
