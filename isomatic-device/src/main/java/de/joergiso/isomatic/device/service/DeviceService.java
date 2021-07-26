package de.joergiso.isomatic.device.service;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.model.value.DeviceModelIdentifier;
import de.joergiso.isomatic.device.domain.unit.DeviceUnit;
import de.joergiso.isomatic.device.domain.unit.DeviceUnitDto;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitRegistrationStatus;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;
import de.joergiso.isomatic.device.exception.DeviceAlreadyRegisteredException;
import de.joergiso.isomatic.device.exception.DeviceModelNotFoundException;
import de.joergiso.isomatic.device.exception.DeviceNotFoundException;
import de.joergiso.isomatic.device.exception.DuplicateSerialNumberException;
import de.joergiso.isomatic.device.repository.DeviceModelRepository;
import de.joergiso.isomatic.device.repository.DeviceUnitRepository;
import de.joergiso.isomatic.device.util.DeviceUnitFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DeviceService {
    private final DeviceModelRepository deviceModelRepository;
    private final DeviceUnitRepository deviceUnitRepository;

    @Autowired
    public DeviceService(DeviceModelRepository deviceModelRepository, DeviceUnitRepository deviceUnitRepository) {
        this.deviceModelRepository = deviceModelRepository;
        this.deviceUnitRepository = deviceUnitRepository;
    }

    public List<DeviceUnitDto> getAllDeviceUnits() {
        return StreamSupport.stream(deviceUnitRepository.findAll().spliterator(), false)
                .map(DeviceUnit::toDto)
                .collect(Collectors.toList());
    }

    public DeviceUnitDto getDeviceUnit(String serialNumber) throws DeviceNotFoundException {
        return deviceUnitRepository.findBySerialNumber(new DeviceUnitSerialNumber(serialNumber))
                .map(DeviceUnit::toDto)
                .orElseThrow(() -> new DeviceNotFoundException(new DeviceUnitSerialNumber(serialNumber)));
    }

    public DeviceUnitRegistrationStatus getDeviceUnitRegistrationStatus(String serialNumber) throws DeviceNotFoundException {
        return deviceUnitRepository.findBySerialNumber(new DeviceUnitSerialNumber(serialNumber))
                .map(DeviceUnit::getRegistrationStatus)
                .orElseThrow(() -> new DeviceNotFoundException(new DeviceUnitSerialNumber(serialNumber)));
    }

    @Transactional
    public DeviceUnitDto createDeviceUnitByDeviceModelIdentifier(String identifier) throws DeviceModelNotFoundException {
        Optional<DeviceModel> optional = deviceModelRepository.findByIdentifier(new DeviceModelIdentifier(identifier));
        DeviceModel model = optional.orElseThrow(DeviceModelNotFoundException::new);

        return createDeviceUnitByDeviceModel(model).toDto();
    }

    @Transactional
    public DeviceUnit createDeviceUnitByDeviceModel(DeviceModel model) throws DuplicateSerialNumberException {
        DeviceUnit deviceUnit = DeviceUnitFactory.build(model);
        return deviceUnitRepository.save(deviceUnit);
    }

    @Transactional
    public void deleteDeviceBySerialNumber(String serialNumber) throws DeviceNotFoundException {
        DeviceUnit entity = this.deviceUnitRepository.findBySerialNumber(new DeviceUnitSerialNumber(serialNumber))
                .orElseThrow(() -> new DeviceNotFoundException(new DeviceUnitSerialNumber(serialNumber)));

        this.deviceUnitRepository.delete(entity);
    }

    @Transactional
    public DeviceUnitDto registerDevice(String serialNumber) throws DeviceNotFoundException, DeviceAlreadyRegisteredException {
        DeviceUnit entity = deviceUnitRepository.findBySerialNumber(new DeviceUnitSerialNumber(serialNumber))
                .orElseThrow(() -> new DeviceNotFoundException(new DeviceUnitSerialNumber(serialNumber)));

        if (entity.isRegistered()) {
            throw new DeviceAlreadyRegisteredException(new DeviceUnitSerialNumber(serialNumber));

        } else {
            entity.setRegistrationStatus(new DeviceUnitRegistrationStatus(DeviceUnitRegistrationStatus.Status.REGISTERED));
            DeviceUnit saved = deviceUnitRepository.save(entity);

            return saved.toDto();
        }
    }

    @Transactional
    public DeviceUnitDto unregisterDevice(String serialNumber) throws DeviceNotFoundException {
        Optional<DeviceUnit> optionalEntity = deviceUnitRepository.findBySerialNumber(new DeviceUnitSerialNumber(serialNumber));
        DeviceUnit entity = optionalEntity.orElseThrow(() -> new DeviceNotFoundException(new DeviceUnitSerialNumber(serialNumber)));

        entity.setRegistrationStatus(new DeviceUnitRegistrationStatus(DeviceUnitRegistrationStatus.Status.UNREGISTERED));
        DeviceUnit saved = deviceUnitRepository.save(entity);

        return saved.toDto();
    }

}
