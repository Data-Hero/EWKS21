package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.controllers.BookingDto;
import de.joergiso.isomaticbooking.controllers.FunctionBundleDto;
import de.joergiso.isomaticbooking.domain.Booking;
import de.joergiso.isomaticbooking.domain.Device;
import de.joergiso.isomaticbooking.domain.Function;
import de.joergiso.isomaticbooking.domain.FunctionBundle;
import de.joergiso.isomaticbooking.exception.DeviceNotFoundException;
import de.joergiso.isomaticbooking.exception.UserNotFoundException;
import de.joergiso.isomaticbooking.repository.FunctionBundleRepository;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
  private final FunctionBundleRepository functionBundleRepository;

  private final DeviceService deviceService;

  private final UserService userService;

  @Autowired
  public Mapper(FunctionBundleRepository functionBundleRepository,
                DeviceService deviceService,
                UserService userService) {
    this.functionBundleRepository = functionBundleRepository;
    this.deviceService = deviceService;
    this.userService = userService;
  }

  public FunctionBundleDto functionBundleToDto(FunctionBundle functionBundle) {
    return new FunctionBundleDto(
        functionBundle.getFunctionBundleId(),
        functionBundle.getFunction()
            .stream().map(Function::getFunctionNumber).collect(Collectors.toList()),
        functionBundle.getPriceByMinute(),
        functionBundle.getDiscount()
    );
  }

  public BookingDto bookingToDto(Booking booking) {
    return new BookingDto(
        booking.getId(),
        booking.getUser().getId(),
        booking.getDevice().getId(),
        booking.getStartTime(),
        booking.getEndTime(),
        booking.getFunctionBundle().getFunctionBundleId()
    );
  }

  public Booking bookingFromDto(BookingDto bookingDto) throws UserNotFoundException, DeviceNotFoundException {
    Booking booking = new Booking();
    booking.setStartTime(bookingDto.getStartTime());
    booking.setEndTime(bookingDto.getEndTime());
    booking.setFunctionBundle(
        functionBundleRepository.getFunctionBundleByFunctionBundleIdEquals(
            bookingDto.getFunctionBundleId()
        )
    );
    // TODO device and user
    booking.setDevice(
        deviceService.fetchDevice(bookingDto.getDeviceId())
    );
    booking.setUser(
        userService.fetchUser(bookingDto.getUserId())
    );
    return booking;
  }

  public FunctionBundle functionBundleFromDto(FunctionBundleDto functionBundleDto) {
    return new FunctionBundle(
        functionBundleDto.getFunctionBundleId(),
        functionNumberToFunction(functionBundleDto.getFunctionNumber()),
        functionBundleDto.getPriceByMinute(),
        functionBundleDto.getDiscount()
    );
  }

  private List<Function> functionNumberToFunction(List<String> functionNumbers) {
    List<Device> devices = deviceService.fetchDevices();
    System.out.println(devices);
    return devices.stream()
        .map(Device::getDeviceFunctions)
        .flatMap(Collection::stream)
        .filter(function -> functionNumbers.contains(function.getFunctionName()))
        .collect(Collectors.toList());
  }

}
