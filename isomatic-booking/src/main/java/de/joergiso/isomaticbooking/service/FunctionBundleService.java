package de.joergiso.isomaticbooking.service;

import de.joergiso.isomatic.device.domain.unit.DeviceUnitDto;
import de.joergiso.isomaticbooking.controller.FunctionBundleDto;
import de.joergiso.isomaticbooking.domain.Device;
import de.joergiso.isomaticbooking.domain.FunctionBundle;
import de.joergiso.isomaticbooking.domain.User;
import de.joergiso.isomaticbooking.exception.UserNotFoundException;
import de.joergiso.isomaticbooking.repository.FunctionBundleRepository;
import de.joergiso.isomaticbooking.repository.RemoteDeviceRepository;
import de.joergiso.isomaticbooking.repository.RemoteUserRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunctionBundleService {
  private final FunctionBundleRepository functionBundleRepository;
  private final Mapper mapper;
  private final RemoteUserRepository remoteUserRepository;
  private final RemoteDeviceRepository remoteDeviceRepository;

  @Autowired
  public FunctionBundleService(FunctionBundleRepository functionBundleRepository,
                               Mapper mapper,
                               RemoteUserRepository remoteUserRepository,
                               RemoteDeviceRepository remoteDeviceRepository) {
    this.functionBundleRepository = functionBundleRepository;
    this.mapper = mapper;
    this.remoteUserRepository = remoteUserRepository;
    this.remoteDeviceRepository = remoteDeviceRepository;
  }
  // Für alle Funktionen im FunctionBundle muss User ein Device haben, welches die Funktionalität besitzt
  public List<FunctionBundleDto> getFunctionBundleByUser(Long userId)
      throws UserNotFoundException {
    User user = remoteUserRepository.fetchUser(userId);

    List<DeviceUnitDto> deviceUnitDtosOfUser = remoteDeviceRepository
        .fetchDevices()
        .stream()
        .filter(deviceUnitDto -> user.getDevices().stream()
                .map(Device::getSerialNumber)
                .collect(Collectors.toList())
                .contains(deviceUnitDto.getSerialNumber().serialNumber))
        .collect(Collectors.toList());

    return StreamSupport.stream(
        functionBundleRepository.findAll().spliterator(), false
      ).filter(fb -> fb.getFunctions().stream().allMatch(
          function -> deviceUnitDtosOfUser.stream().flatMap(deviceUnitDto -> deviceUnitDto
                .getModelDto()
                .getFunctions()
                .stream())
              .anyMatch((deviceFunction) -> function.equals(deviceFunction.getName().name))))
        .map(mapper::functionBundleToDto)
        .collect(Collectors.toList());
  }

  public List<FunctionBundleDto> getFunctionBundles() {
    return StreamSupport.stream(functionBundleRepository.findAll().spliterator(), false)
        .map(mapper::functionBundleToDto)
        .collect(Collectors.toList());
  }

  public FunctionBundle addFunctionBundle(FunctionBundleDto functionBundleDto){
    return functionBundleRepository.save(mapper.functionBundleFromDto(functionBundleDto));
  }
}
