package de.joergiso.isomatic.device.domain.unit;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;

public class DeviceUnitDto {
    private DeviceUnitSerialNumber serialNumber;
    private DeviceModel model;

    public DeviceUnitDto(DeviceUnitSerialNumber serialNumber, DeviceModel model) {
        this.serialNumber = serialNumber;
        this.model = model;
    }

    public DeviceUnitSerialNumber getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(DeviceUnitSerialNumber serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DeviceModel getModel() {
        return model;
    }

    public void setModel(DeviceModel model) {
        this.model = model;
    }
}
