package de.joergiso.isomatic.device.domain.unit;

import de.joergiso.isomatic.device.domain.model.DeviceModelDto;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitRegistrationStatus;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;

public class DeviceUnitDto {
    private DeviceUnitSerialNumber serialNumber;
    private DeviceUnitRegistrationStatus registrationStatus;
    private DeviceModelDto modelDto;

    public DeviceUnitDto(DeviceUnitSerialNumber serialNumber, DeviceUnitRegistrationStatus registrationStatus, DeviceModelDto modelDto) {
        this.serialNumber = serialNumber;
        this.registrationStatus = registrationStatus;
        this.modelDto = modelDto;
    }

    public DeviceUnitSerialNumber getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(DeviceUnitSerialNumber serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DeviceUnitRegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(DeviceUnitRegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public DeviceModelDto getModelDto() {
        return modelDto;
    }

    public void setModelDto(DeviceModelDto modelDto) {
        this.modelDto = modelDto;
    }
}
