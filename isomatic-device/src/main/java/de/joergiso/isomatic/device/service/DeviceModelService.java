package de.joergiso.isomatic.device.service;

import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.model.DeviceModelDto;
import de.joergiso.isomatic.device.domain.model.value.DeviceManufacturer;
import de.joergiso.isomatic.device.domain.model.value.DeviceName;
import de.joergiso.isomatic.device.domain.model.value.DeviceType;
import de.joergiso.isomatic.device.exception.DeviceModelNotFoundException;
import de.joergiso.isomatic.device.repository.DeviceModelRepository;
import de.joergiso.isomatic.device.request.CreateDeviceModelRequest;
import de.joergiso.isomatic.device.util.DeviceFunctionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DeviceModelService {
    private final DeviceModelRepository deviceModelRepository;

    @Autowired
    public DeviceModelService(DeviceModelRepository deviceModelRepository) {
        this.deviceModelRepository = deviceModelRepository;
    }

    public List<DeviceModelDto> getAllDeviceModels() {
        return StreamSupport.stream(deviceModelRepository.findAll().spliterator(), false)
                .map(DeviceModel::toDto)
                .collect(Collectors.toList());
    }

    public DeviceModelDto getDeviceModelById(long id) {
        return deviceModelRepository.findById(id).orElseThrow(DeviceModelNotFoundException::new).toDto();
    }

    @Transactional
    public DeviceModelDto createDeviceModel(CreateDeviceModelRequest request) {
        DeviceModelDto dto = new DeviceModelDto(
                new DeviceType(request.getType()),
                new DeviceName(request.getName()),
                new DeviceManufacturer(request.getManufacturerAbbr(), request.getManufacturerName()),
                request.getFunctionBlueprints().stream().map(DeviceFunctionFactory::build).collect(Collectors.toSet())
        );

        return this.deviceModelRepository.save(new DeviceModel().fromDto(dto)).toDto();
    }
}
