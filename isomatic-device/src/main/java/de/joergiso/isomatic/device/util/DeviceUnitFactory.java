package de.joergiso.isomatic.device.util;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.unit.DeviceUnit;

public interface DeviceUnitFactory {
    public DeviceUnit build(DeviceModel model);
}
