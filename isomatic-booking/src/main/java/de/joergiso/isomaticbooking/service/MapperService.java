package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.controller.BookingDto;
import de.joergiso.isomaticbooking.controller.FunctionBundleDto;
import de.joergiso.isomaticbooking.domain.Booking;
import de.joergiso.isomaticbooking.domain.FunctionBundle;
import de.joergiso.isomaticbooking.exception.DeviceNotFoundException;
import de.joergiso.isomaticbooking.exception.UserNotFoundException;
import de.joergiso.isomaticbooking.repository.FunctionBundleRepository;
import de.joergiso.isomaticbooking.repository.RemoteDeviceRepository;
import de.joergiso.isomaticbooking.repository.RemoteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperService {
  private final FunctionBundleRepository functionBundleRepository;

  private final RemoteDeviceRepository remoteDeviceRepository;

  private final RemoteUserRepository remoteUserRepository;

  @Autowired
  public MapperService(FunctionBundleRepository functionBundleRepository,
                       RemoteDeviceRepository remoteDeviceRepository,
                       RemoteUserRepository remoteUserRepository) {
    this.functionBundleRepository = functionBundleRepository;
    this.remoteDeviceRepository = remoteDeviceRepository;
    this.remoteUserRepository = remoteUserRepository;
  }

  public FunctionBundleDto functionBundleToDto(FunctionBundle functionBundle) {
    return new FunctionBundleDto(
        functionBundle.getFunctionBundleId(),
        functionBundle.getFunctions(),
        functionBundle.getPriceByMinute(),
        functionBundle.getDiscount()
    );
  }

  public BookingDto bookingToDto(Booking booking) {
    System.out.println(booking);
    return new BookingDto(
        booking.getUser().getId(),
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
    booking.setUser(
        remoteUserRepository.fetchUser(bookingDto.getUserId())
    );
    return booking;
  }

  public FunctionBundle functionBundleFromDto(FunctionBundleDto functionBundleDto) {
    return new FunctionBundle(
        functionBundleDto.getFunctionBundleId(),
        functionBundleDto.getFunctionNumber(),
        functionBundleDto.getPriceByMinute(),
        functionBundleDto.getDiscount()
    );
  }
}
