package de.joergiso.isomatic.device.util;

import de.joergiso.isomatic.device.domain.function.DeviceFunctionDto;
import de.joergiso.isomatic.device.domain.model.DeviceModelDto;
import de.joergiso.isomatic.device.domain.model.value.DeviceManufacturer;
import de.joergiso.isomatic.device.domain.model.value.DeviceName;
import de.joergiso.isomatic.device.domain.model.value.DeviceType;

import java.util.Set;

public class DeviceModelFactory {

    public static DeviceModelDto build(String type, String name, DeviceManufacturer man, Set<DeviceFunctionDto> functions) {
        return build(type, name, man.manAbbr, man.manName, functions);
    }

    public static DeviceModelDto build(String type, String name, String manAbbr, String manName, Set<DeviceFunctionDto> functions) {
        return new DeviceModelDto(new DeviceType(type), new DeviceName(name), new DeviceManufacturer(manAbbr, manName), functions);
    }
}
