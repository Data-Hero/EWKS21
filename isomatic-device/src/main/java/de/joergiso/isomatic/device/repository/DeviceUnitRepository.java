package de.joergiso.isomatic.device.repository;

import de.joergiso.isomatic.device.domain.unit.DeviceUnit;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeviceUnitRepository extends CrudRepository<DeviceUnit, Long> {
    Optional<DeviceUnit> findBySerialNumber(DeviceUnitSerialNumber serialNumber);
}