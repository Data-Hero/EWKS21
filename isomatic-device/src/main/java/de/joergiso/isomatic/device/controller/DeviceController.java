package de.joergiso.isomatic.device.controller;

import de.joergiso.isomatic.device.domain.unit.DeviceUnitDto;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitRegistrationStatus;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;
import de.joergiso.isomatic.device.exception.DeviceAlreadyRegisteredException;
import de.joergiso.isomatic.device.exception.DeviceNotFoundException;
import de.joergiso.isomatic.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }


    @GetMapping("/devices")
    public List<DeviceUnitDto> getAllDevices() {
        return deviceService.getAllDeviceUnits();
    }

    @GetMapping("/devices/{serialNumber}")
    public DeviceUnitDto getDevice(@PathVariable DeviceUnitSerialNumber serialNumber) throws DeviceNotFoundException {
        return deviceService.getDeviceUnit(serialNumber);
    }

    @GetMapping("/devices/{serialNumber}/registration")
    public DeviceUnitRegistrationStatus getDeviceRegistrationStatus(@PathVariable DeviceUnitSerialNumber serialNumber) throws DeviceNotFoundException {
        return deviceService.getDeviceUnitRegistrationStatus(serialNumber);
    }

    @PostMapping("/devices/{serialNumber}/registration")
    public DeviceUnitDto registerDevice(@PathVariable DeviceUnitSerialNumber serialNumber) throws DeviceNotFoundException, DeviceAlreadyRegisteredException {
        return deviceService.registerDevice(serialNumber);
    }

    @DeleteMapping("/devices/{serialNumber}/registration")
    public DeviceUnitDto unregisterDevice(@PathVariable DeviceUnitSerialNumber serialNumber) throws DeviceNotFoundException {
        return deviceService.unregisterDevice(serialNumber);
    }

}
