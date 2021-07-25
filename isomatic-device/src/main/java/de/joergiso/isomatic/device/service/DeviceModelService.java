package de.joergiso.isomatic.device.service;

import de.joergiso.isomatic.device.domain.function.DeviceFunction;
import de.joergiso.isomatic.device.domain.function.DeviceFunctionDto;
import de.joergiso.isomatic.device.domain.model.DeviceModel;
import de.joergiso.isomatic.device.domain.model.DeviceModelDto;
import de.joergiso.isomatic.device.domain.model.value.DeviceModelIdentifier;
import de.joergiso.isomatic.device.exception.DeviceModelNotFoundException;
import de.joergiso.isomatic.device.repository.DeviceFunctionRepository;
import de.joergiso.isomatic.device.repository.DeviceModelRepository;
import de.joergiso.isomatic.device.request.CreateDeviceModelRequest;
import de.joergiso.isomatic.device.util.DeviceFunctionFactory;
import de.joergiso.isomatic.device.util.DeviceModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DeviceModelService {
    private final DeviceFunctionRepository deviceFunctionRepository;
    private final DeviceModelRepository deviceModelRepository;

    @Autowired
    public DeviceModelService(DeviceFunctionRepository deviceFunctionRepository, DeviceModelRepository deviceModelRepository) {
        this.deviceFunctionRepository = deviceFunctionRepository;
        this.deviceModelRepository = deviceModelRepository;
    }

    public List<DeviceModelDto> getAllDeviceModels() {
        return StreamSupport.stream(deviceModelRepository.findAll().spliterator(), false)
                .map(DeviceModel::toDto)
                .collect(Collectors.toList());
    }

    public DeviceModelDto getDeviceModelByIdentifier(String identifier) {
        return deviceModelRepository.findByIdentifier(new DeviceModelIdentifier(identifier)).orElseThrow(DeviceModelNotFoundException::new).toDto();
    }

    @Transactional
    public DeviceModelDto createDeviceModel(CreateDeviceModelRequest request) {
        DeviceModelDto dto = DeviceModelFactory.build(
                request.getType(),
                request.getName(),
                request.getManufacturerAbbr(),
                request.getManufacturerName(),
                request.getFunctionBlueprints().stream()
                        .map(DeviceFunctionFactory::build)
                        .map(this::preprocessDeviceFunction)
                        .collect(Collectors.toSet())
        );

        return createDeviceModel(dto);
    }

    @Transactional
    public DeviceModelDto createDeviceModel(DeviceModelDto dto) {
        return this.deviceModelRepository.save(new DeviceModel().fromDto(dto)).toDto();
    }

    private DeviceFunctionDto preprocessDeviceFunction(DeviceFunctionDto function) {
        DeviceFunction saved = deviceFunctionRepository.save(new DeviceFunction().fromDto(function));
        return saved.toDto();
    }
}
