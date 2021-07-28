package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.controller.BookingDto;
import de.joergiso.isomaticbooking.controller.BookingInformationDto;
import de.joergiso.isomaticbooking.domain.Booking;
import de.joergiso.isomaticbooking.exception.UserNotFoundException;
import de.joergiso.isomaticbooking.repository.BookingRepository;
import de.joergiso.isomaticbooking.repository.FunctionBundleRepository;
import de.joergiso.isomaticbooking.repository.RemoteUserRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  private final BookingRepository bookingRepository;

  private final FunctionBundleRepository functionBundleRepository;


  private final RemoteUserRepository remoteUserRepository;

  private final Mapper mapper;

  @Autowired
  public BookingService(BookingRepository bookingRepository,
                        FunctionBundleRepository functionBundleRepository,
                        RemoteUserRepository remoteUserRepository,
                        Mapper mapper) {
    this.bookingRepository = bookingRepository;
    this.functionBundleRepository = functionBundleRepository;
    this.remoteUserRepository = remoteUserRepository;
    this.mapper = mapper;
  }

  public List<BookingDto> getAllBookings() {
    LinkedList<Booking> result = new LinkedList<>();
    bookingRepository.findAll().forEach(result::add);
    return result.stream()
        .filter(booking -> booking.getUser() != null && booking.getFunctionBundle() != null)
        .map(mapper::bookingToDto)
        .collect(Collectors.toList());
  }

  public BookingDto book(String functionBundleId,
                         BookingInformationDto bookingInformationDto)
      throws UserNotFoundException {
    Booking booking = new Booking();
    booking.setFunctionBundle(functionBundleRepository.getFunctionBundleByFunctionBundleIdEquals(functionBundleId));
    booking.setUser(remoteUserRepository.fetchUser(bookingInformationDto.getUserId()));
    booking.setStartTime(bookingInformationDto.getStartTime());
    booking.setEndTime(bookingInformationDto.getEndTime());
    bookingRepository.save(booking);
    return mapper.bookingToDto(booking);
  }
}
