package de.joergiso.isomatic.device.controller;

import de.joergiso.isomatic.device.domain.model.DeviceModelDto;
import de.joergiso.isomatic.device.request.CreateDeviceModelRequest;
import de.joergiso.isomatic.device.service.DeviceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("device/models")
public class DeviceModelController {
    private final DeviceModelService deviceModelService;

    @Autowired
    public DeviceModelController(DeviceModelService deviceModelService) {
        this.deviceModelService = deviceModelService;
    }

    @GetMapping()
    public List<DeviceModelDto> getAllDeviceModels() {
        return deviceModelService.getAllDeviceModels();
    }

    @PostMapping()
    public DeviceModelDto createDeviceModel(@RequestBody CreateDeviceModelRequest request) {
        return deviceModelService.createDeviceModel(request);
    }

    @GetMapping("/{identifier}")
    public DeviceModelDto getDeviceModelByIdentifier(@PathVariable("identifier") String identifier) {
        return deviceModelService.getDeviceModelByIdentifier(identifier);
    }
}
