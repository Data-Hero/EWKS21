package de.joergiso.isomatic.device.domain.unit;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;

import javax.persistence.*;

@Entity
public class DeviceUnit {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private DeviceUnitSerialNumber serialNumber;

    @OneToOne
    private DeviceModel model;
}
