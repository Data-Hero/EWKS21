package de.joergiso.isomatic.device.controller;

import de.joergiso.isomatic.device.domain.unit.DeviceUnitDto;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitRegistrationStatus;
import de.joergiso.isomatic.device.domain.unit.value.DeviceUnitSerialNumber;
import de.joergiso.isomatic.device.exception.DeviceAlreadyRegisteredException;
import de.joergiso.isomatic.device.exception.DeviceNotFoundException;
import de.joergiso.isomatic.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController()
@RequestMapping("device/devices")
public class DeviceController {

    @Value("${foo.bar:default}")
    private final String fooBar = "empty";

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/config")
    public String getFooBar() {
        return fooBar;
    }

    @GetMapping()
    public List<DeviceUnitDto> getAllDevices() {
        return deviceService.getAllDeviceUnits();
    }

    @PostMapping()
    public DeviceUnitDto createDeviceByModelIdentifier(@RequestParam String identifier) {
        return deviceService.createDeviceUnitByDeviceModelIdentifier(identifier);
    }

    @GetMapping("/{serialNumber}")
    public DeviceUnitDto getDevice(@PathVariable String serialNumber) throws DeviceNotFoundException {
        return deviceService.getDeviceUnit(serialNumber);
    }

    @DeleteMapping("/{serialNumber}")
    public void deleteDevice(@PathVariable String serialNumber) throws DeviceNotFoundException {
        deviceService.deleteDeviceBySerialNumber(serialNumber);
    }

    @GetMapping("/{serialNumber}/registration")
    public DeviceUnitRegistrationStatus getDeviceRegistrationStatus(@PathVariable String serialNumber) throws DeviceNotFoundException {
        return deviceService.getDeviceUnitRegistrationStatus(serialNumber);
    }

    @PostMapping("/{serialNumber}/registration")
    public DeviceUnitDto registerDevice(@PathVariable String serialNumber) throws DeviceNotFoundException, DeviceAlreadyRegisteredException {
        return deviceService.registerDevice(serialNumber);
    }

    @DeleteMapping("/{serialNumber}/registration")
    public DeviceUnitDto unregisterDevice(@PathVariable String serialNumber) throws DeviceNotFoundException {
        return deviceService.unregisterDevice(serialNumber);
    }

}
