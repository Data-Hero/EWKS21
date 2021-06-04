package de.joergiso.isomatic.device.service;

import de.joergiso.isomatic.device.domain.unit.DeviceUnit;
import de.joergiso.isomatic.device.domain.unit.DeviceUnitDto;
import de.joergiso.isomatic.device.exception.DeviceAlreadyRegisteredException;
import de.joergiso.isomatic.device.exception.DeviceNotFoundException;
import de.joergiso.isomatic.device.repository.DeviceUnitRepository;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitRegistrationStatus;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DeviceService {
    private final DeviceUnitRepository deviceUnitRepository;

    @Autowired
    public DeviceService(DeviceUnitRepository deviceUnitRepository) {
        this.deviceUnitRepository = deviceUnitRepository;
    }

    public List<DeviceUnitDto> getAllDeviceUnits() {
        return StreamSupport.stream(deviceUnitRepository.findAll().spliterator(), false)
                .map(DeviceUnit::toDto)
                .collect(Collectors.toList());
    }

    public DeviceUnitDto getDeviceUnit(DeviceUnitSerialNumber serialNumber) throws DeviceNotFoundException {
        return deviceUnitRepository.findBySerialNumber(serialNumber).map(DeviceUnit::toDto).orElseThrow(() -> new DeviceNotFoundException(serialNumber));
    }

    public DeviceUnitRegistrationStatus getDeviceUnitRegistrationStatus(DeviceUnitSerialNumber serialNumber) throws DeviceNotFoundException {
        return deviceUnitRepository.findBySerialNumber(serialNumber).map(DeviceUnit::getRegistrationStatus).orElseThrow(() -> new DeviceNotFoundException(serialNumber));
    }

    @Transactional
    public DeviceUnitDto registerDevice(DeviceUnitSerialNumber serialNumber) throws DeviceNotFoundException, DeviceAlreadyRegisteredException {
        Optional<DeviceUnit> optionalEntity = deviceUnitRepository.findBySerialNumber(serialNumber);
        DeviceUnit entity = optionalEntity.orElseThrow(() -> new DeviceNotFoundException(serialNumber));

        if (entity.isRegistered()) {
            throw new DeviceAlreadyRegisteredException(serialNumber);

        } else {
            entity.setRegistrationStatus(new DeviceUnitRegistrationStatus(DeviceUnitRegistrationStatus.Type.REGISTERED));
            DeviceUnit saved = deviceUnitRepository.save(entity);

            return saved.toDto();
        }
    }

    @Transactional
    public DeviceUnitDto unregisterDevice(DeviceUnitSerialNumber serialNumber) throws DeviceNotFoundException {
        Optional<DeviceUnit> optionalEntity = deviceUnitRepository.findBySerialNumber(serialNumber);
        DeviceUnit entity = optionalEntity.orElseThrow(() -> new DeviceNotFoundException(serialNumber));

        entity.setRegistrationStatus(new DeviceUnitRegistrationStatus(DeviceUnitRegistrationStatus.Type.UNREGISTERED));
        DeviceUnit saved = deviceUnitRepository.save(entity);

        return saved.toDto();
    }

}
