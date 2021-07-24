package de.joergiso.isomatic.device.controller;

import de.joergiso.isomatic.device.domain.model.DeviceModelDto;
import de.joergiso.isomatic.device.request.CreateDeviceModelRequest;
import de.joergiso.isomatic.device.service.DeviceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
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

    @GetMapping("/{id}")
    public DeviceModelDto getDeviceModelById(@PathVariable("id") long id) {
        return deviceModelService.getDeviceModelById(id);
    }
}
