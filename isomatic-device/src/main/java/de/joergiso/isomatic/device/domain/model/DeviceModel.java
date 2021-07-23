package de.joergiso.isomatic.device.domain.model;

import de.joergiso.isomatic.device.domain.function.DeviceFunction;
import de.joergiso.isomatic.device.domain.model.value.DeviceManufacturer;
import de.joergiso.isomatic.device.domain.model.value.DeviceName;
import de.joergiso.isomatic.device.domain.model.value.DeviceType;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

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

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<DeviceFunction> functions;


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

    public Set<DeviceFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(Set<DeviceFunction> functions) {
        this.functions = functions;
    }

    public DeviceModel fromDto(DeviceModelDto dto) {
        this.type = dto.getType();
        this.name = dto.getName();
        this.manufacturer = dto.getManufacturer();
        this.functions = dto.getFunctions().stream().map(it -> new DeviceFunction().fromDto(it)).collect(Collectors.toSet());

        return this;
    }

    public DeviceModelDto toDto() {
        return new DeviceModelDto(type, name, manufacturer, functions.stream().map(DeviceFunction::toDto).collect(Collectors.toSet()));
    }
}
