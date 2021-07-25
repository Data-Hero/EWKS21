package de.joergiso.isomatic.device.repository;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.model.value.DeviceModelIdentifier;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeviceModelRepository extends CrudRepository<DeviceModel, Long> {
    Optional<DeviceModel> findByIdentifier(DeviceModelIdentifier identifier);
}
