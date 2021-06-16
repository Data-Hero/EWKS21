package de.joergiso.isomaticbooking.controllers;

import de.joergiso.isomaticbooking.domain.Booking;
import de.joergiso.isomaticbooking.domain.FunctionBundle;
import de.joergiso.isomaticbooking.domain.User;
import de.joergiso.isomaticbooking.service.BookingService;
import de.joergiso.isomaticbooking.service.FunctionBundleService;
import java.util.List;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
  private final BookingService bookingService;

  private final FunctionBundleService functionBundleService;

  @Autowired
  public BookingController(BookingService bookingService, FunctionBundleService functionBundleService) {
    this.bookingService = bookingService;
    this.functionBundleService = functionBundleService;
  }

  @GetMapping("/booking")
  public List<Booking> getAllBookings() {
    return bookingService.getAllBookings();
  }

  @GetMapping("/functionBundles")
  public List<FunctionBundle> getAvailableFunctionBundles(User user) {
    return functionBundleService.getFunctionBundleByUser(user);
  }

  @PostMapping("/book")
  public Response bookFunctionBundle() {
      return Response.ok().build();
  }
}
