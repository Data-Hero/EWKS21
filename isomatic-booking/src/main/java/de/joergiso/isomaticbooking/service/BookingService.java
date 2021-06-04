package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.domain.Booking;
import de.joergiso.isomaticbooking.repository.BookingRepository;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  private  BookingRepository bookingRepository;

  @Autowired
  public BookingService(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  public List<Booking> getAllBookings() {
    LinkedList<Booking> result = new LinkedList<>();
    bookingRepository.findAll().forEach(result::add);
    return result;
  }
}
