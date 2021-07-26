package de.joergiso.isomatic.device.domain.model;

import de.joergiso.isomatic.device.domain.function.DeviceFunction;
import de.joergiso.isomatic.device.domain.model.value.DeviceManufacturer;
import de.joergiso.isomatic.device.domain.model.value.DeviceModelIdentifier;
import de.joergiso.isomatic.device.domain.model.value.DeviceName;
import de.joergiso.isomatic.device.domain.model.value.DeviceType;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class DeviceModel {
    @Id @GeneratedValue
    private Long id;

    @Embedded
    @Column
    private DeviceModelIdentifier identifier;

    @Embedded
    @Column
    private DeviceType type;

    @Embedded
    @Column
    private DeviceName name;

    @Embedded
    private DeviceManufacturer manufacturer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<DeviceFunction> functions;


    public Long getId() {
        return id;
    }

    public DeviceModelIdentifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(DeviceModelIdentifier identifier) {
        this.identifier = identifier;
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

    public List<DeviceFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(List<DeviceFunction> functions) {
        this.functions = functions;
    }

    public DeviceModel fromDto(DeviceModelDto dto) {
        this.identifier = dto.getIdentifier();
        this.type = dto.getType();
        this.name = dto.getName();
        this.manufacturer = dto.getManufacturer();
        this.functions = dto.getFunctions().stream().map(it -> new DeviceFunction().fromDto(it)).collect(Collectors.toList());

        return this;
    }

    public DeviceModelDto toDto() {
        return new DeviceModelDto(identifier, type, name, manufacturer, functions.stream().map(DeviceFunction::toDto).collect(Collectors.toList()));
    }
}
