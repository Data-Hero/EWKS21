package de.joergiso.isomatic.device.util;

import de.joergiso.isomatic.device.domain.function.DeviceFunctionDto;
import de.joergiso.isomatic.device.domain.model.DeviceModelDto;
import de.joergiso.isomatic.device.domain.model.value.DeviceManufacturer;
import de.joergiso.isomatic.device.domain.model.value.DeviceModelIdentifier;
import de.joergiso.isomatic.device.domain.model.value.DeviceName;
import de.joergiso.isomatic.device.domain.model.value.DeviceType;

import java.util.List;
import java.util.UUID;

public class DeviceModelFactory {

    public static DeviceModelDto build(String type, String name, DeviceManufacturer man, List<DeviceFunctionDto> functions) {
        return build(type, name, man.manAbbr, man.manName, functions);
    }

    public static DeviceModelDto build(String type, String name, String manAbbr, String manName, List<DeviceFunctionDto> functions) {
        return new DeviceModelDto(
                new DeviceModelIdentifier(UUID.randomUUID().toString()),
                new DeviceType(type),
                new DeviceName(name),
                new DeviceManufacturer(manAbbr, manName), functions
        );
    }
}
