package de.joergiso.isomatic.device.domain.model;

import de.joergiso.isomatic.device.domain.function.DeviceFunctionDto;
import de.joergiso.isomatic.device.domain.model.value.DeviceManufacturer;
import de.joergiso.isomatic.device.domain.model.value.DeviceModelIdentifier;
import de.joergiso.isomatic.device.domain.model.value.DeviceName;
import de.joergiso.isomatic.device.domain.model.value.DeviceType;

import java.util.Set;

public class DeviceModelDto {
    private DeviceModelIdentifier identifier;
    private DeviceType type;
    private DeviceName name;
    private DeviceManufacturer manufacturer;
    Set<DeviceFunctionDto> functions;

    public DeviceModelDto(DeviceModelIdentifier identifier, DeviceType type, DeviceName name, DeviceManufacturer manufacturer, Set<DeviceFunctionDto> functions) {
        this.identifier = identifier;
        this.type = type;
        this.name = name;
        this.manufacturer = manufacturer;
        this.functions = functions;
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

    public Set<DeviceFunctionDto> getFunctions() {
        return functions;
    }

    public void setFunctions(Set<DeviceFunctionDto> functions) {
        this.functions = functions;
    }
}
