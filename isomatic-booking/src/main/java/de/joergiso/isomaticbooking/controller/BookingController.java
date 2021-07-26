package de.joergiso.isomaticbooking.controller;

import de.joergiso.isomaticbooking.exception.DeviceNotFoundException;
import de.joergiso.isomaticbooking.exception.UserNotFoundException;
import de.joergiso.isomaticbooking.service.BookingService;
import de.joergiso.isomaticbooking.service.ConfigurationService;
import de.joergiso.isomaticbooking.service.FunctionBundleService;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingController {
  private final BookingService bookingService;

  private final FunctionBundleService functionBundleService;

  private final ConfigurationService configurationService;


  @Autowired
  public BookingController(BookingService bookingService,
                           FunctionBundleService functionBundleService,
                           ConfigurationService configurationService) {
    this.bookingService = bookingService;
    this.functionBundleService = functionBundleService;
    this.configurationService = configurationService;
  }

  @GetMapping("/config")
  public String getConfig() {
    return configurationService.getDeviceEndpoint();
  }

  @GetMapping("/booking")
  public List<BookingDto> getAllBookings() {
    return bookingService.getAllBookings();
  }

  @GetMapping(value = "/functionBundle/{userId}", produces = MediaType.APPLICATION_JSON)
  public List<FunctionBundleDto> getAvailableFunctionBundles(@PathVariable Long userId) throws UserNotFoundException {
    return functionBundleService.getFunctionBundleByUser(userId);
  }

  @PostMapping("/functionBundle/add")
  public void addFunctionBundle(@RequestBody FunctionBundleDto functionBundleDto) {
    functionBundleService.addFunctionBundle(functionBundleDto);
  }

  @PostMapping("/book/{functionBundleId}")
  @ResponseBody
  public BookingDto bookFunctionBundle(@PathVariable String functionBundleId,
                                       @RequestBody BookingInformationDto bookingInformationDto)
      throws UserNotFoundException, DeviceNotFoundException {
    return bookingService.book(functionBundleId, bookingInformationDto);
  }


}
