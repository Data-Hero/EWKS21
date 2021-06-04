package de.joergiso.isomaticbooking.controllers;

import de.joergiso.isomaticbooking.domain.Booking;
import de.joergiso.isomaticbooking.service.BookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
  public BookingService bookingService;

  @Autowired
  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @GetMapping("/booking")
  public List<Booking> getAllBookings() {
    return bookingService.getAllBookings();
  }
}
