package de.joergiso.isomatic.device.repository;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeviceModelRepository extends CrudRepository<DeviceModel, Long> {
}
