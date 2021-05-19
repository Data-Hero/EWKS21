package de.joergiso.isomatic.device.domain.model;

import de.joergiso.isomatic.device.domain.functionality.DeviceFunction;
import de.joergiso.isomatic.device.domain.model.value.DeviceManufacturer;
import de.joergiso.isomatic.device.domain.model.value.DeviceType;

import javax.persistence.*;
import java.util.Set;

@Entity
public class DeviceModel {
    @Id @GeneratedValue
    private Long id;

    @Column
    private DeviceType type;

    @Column
    private DeviceManufacturer manufacturer;

    @OneToMany
    private Set<DeviceFunction> deviceFunctions;

}
