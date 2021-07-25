package de.joergiso.isomatic.device.domain.unit;

import de.joergiso.isomatic.device.domain.model.DeviceModelDto;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;

public class DeviceUnitDto {
    private DeviceUnitSerialNumber serialNumber;
    private DeviceModelDto modelDto;

    public DeviceUnitDto(DeviceUnitSerialNumber serialNumber, DeviceModelDto modelDto) {
        this.serialNumber = serialNumber;
        this.modelDto = modelDto;
    }

    public DeviceUnitSerialNumber getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(DeviceUnitSerialNumber serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DeviceModelDto getModelDto() {
        return modelDto;
    }

    public void setModelDto(DeviceModelDto modelDto) {
        this.modelDto = modelDto;
    }
}
