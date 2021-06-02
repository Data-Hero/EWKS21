package de.joergiso.isomatic.device.domain.model;

import de.joergiso.isomatic.device.domain.function.DeviceFunction;
import de.joergiso.isomatic.device.domain.model.value.DeviceManufacturer;
import de.joergiso.isomatic.device.domain.model.value.DeviceName;
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
    private DeviceName name;

    @Column
    private DeviceManufacturer manufacturer;

    @OneToMany
    private Set<DeviceFunction> deviceFunctions;


    public Long getId() {
        return id;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public DeviceName getName() {
        return name;
    }

    public void setName(DeviceName name) {
        this.name = name;
    }

    public DeviceManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(DeviceManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<DeviceFunction> getDeviceFunctions() {
        return deviceFunctions;
    }

    public void setDeviceFunctions(Set<DeviceFunction> deviceFunctions) {
        this.deviceFunctions = deviceFunctions;
    }
}
