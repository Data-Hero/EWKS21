package de.joergiso.isomatic.device.domain.unit;

import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;
import org.springframework.data.repository.CrudRepository;

public interface DeviceUnitRepository extends CrudRepository<Long, DeviceUnit> {
    DeviceUnit findBySerialNumber(DeviceUnitSerialNumber serialNumber);
}
