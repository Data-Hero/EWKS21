package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.controllers.BookingDto;
import de.joergiso.isomaticbooking.controllers.FunctionBundleDto;
import de.joergiso.isomaticbooking.domain.Booking;
import de.joergiso.isomaticbooking.repository.BookingRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  private  BookingRepository bookingRepository;

  private final Mapper mapper;

  @Autowired
  public BookingService(BookingRepository bookingRepository,
                        Mapper mapper) {
    this.bookingRepository = bookingRepository;
    this.mapper = mapper;
  }

  public List<BookingDto> getAllBookings() {
    LinkedList<Booking> result = new LinkedList<>();
    bookingRepository.findAll().forEach(result::add);
    return result.stream()
        .map(mapper::bookingToDto)
        .collect(Collectors.toList());
  }

  public BookingDto book(FunctionBundleDto functionBundleDto) {
    return mapper.bookingToDto(
        new Booking()
    );
  }
}
