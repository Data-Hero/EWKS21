package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.controller.BookingDto;
import de.joergiso.isomaticbooking.controller.BookingInformationDto;
import de.joergiso.isomaticbooking.domain.Booking;
import de.joergiso.isomaticbooking.exception.DeviceNotFoundException;
import de.joergiso.isomaticbooking.exception.UserNotFoundException;
import de.joergiso.isomaticbooking.repository.BookingRepository;
import de.joergiso.isomaticbooking.repository.FunctionBundleRepository;
import de.joergiso.isomaticbooking.repository.RemoteDeviceRepository;
import de.joergiso.isomaticbooking.repository.RemoteUserRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  private final BookingRepository bookingRepository;

  private FunctionBundleRepository functionBundleRepository;

  private RemoteDeviceRepository remoteDeviceRepository;

  private RemoteUserRepository remoteUserRepository;

  private final Mapper mapper;

  @Autowired
  public BookingService(BookingRepository bookingRepository,
                        FunctionBundleRepository functionBundleRepository,
                        RemoteDeviceRepository remoteDeviceRepository,
                        RemoteUserRepository remoteUserRepository,
                        Mapper mapper) {
    this.bookingRepository = bookingRepository;
    this.functionBundleRepository = functionBundleRepository;
    this.remoteDeviceRepository = remoteDeviceRepository;
    this.remoteUserRepository = remoteUserRepository;
    this.mapper = mapper;
  }

  public List<BookingDto> getAllBookings() {
    LinkedList<Booking> result = new LinkedList<>();
    bookingRepository.findAll().forEach(result::add);
    return result.stream()
        .map(mapper::bookingToDto)
        .collect(Collectors.toList());
  }

  public BookingDto book(String functionBundleId,
                         BookingInformationDto bookingInformationDto)
      throws UserNotFoundException, DeviceNotFoundException {
    Booking booking = new Booking();
    booking.setFunctionBundle(functionBundleRepository.getFunctionBundleByFunctionBundleIdEquals(functionBundleId));
    booking.setUser(remoteUserRepository.fetchUser(bookingInformationDto.getUserId()));
    booking.setDevice(remoteDeviceRepository.fetchDevice(bookingInformationDto.getDeviceId()));
    booking.setStartTime(bookingInformationDto.getStartTime());
    booking.setStartTime(bookingInformationDto.getEndTime());
    bookingRepository.save(booking);
    return mapper.bookingToDto(booking);
  }
}
