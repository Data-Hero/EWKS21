package de.joergiso.isomatic.device.domain.unit.value;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
public class DeviceUnitRegistrationStatus implements Serializable {
    @Enumerated(EnumType.STRING)
    public final Status status;

    public DeviceUnitRegistrationStatus() {
        this.status = Status.UNREGISTERED;
    }

    public DeviceUnitRegistrationStatus(Status status) {
        this.status = status;
    }


    public enum Status {
        UNREGISTERED, REGISTERED;
    }
}
