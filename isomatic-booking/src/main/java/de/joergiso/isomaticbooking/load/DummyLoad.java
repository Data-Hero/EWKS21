package de.joergiso.isomaticbooking.load;

import de.joergiso.isomaticbooking.domain.Booking;
import de.joergiso.isomaticbooking.domain.FunctionBundle;
import de.joergiso.isomaticbooking.repository.BookingRepository;
import de.joergiso.isomaticbooking.repository.FunctionBundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class DummyLoad implements ApplicationListener<ContextRefreshedEvent> {
  private BookingRepository bookingRepository;
  private FunctionBundleRepository functionBundleRepository;

  @Autowired
  public DummyLoad(BookingRepository bookingRepository, FunctionBundleRepository functionBundleRepository) {
    this.bookingRepository = bookingRepository;
    this.functionBundleRepository = functionBundleRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData() {
    FunctionBundle functionBundle1 = new FunctionBundle();
    FunctionBundle functionBundle2 = new FunctionBundle();
    FunctionBundle functionBundle3 = new FunctionBundle();

    Booking booking1 = new Booking();
    Booking booking2 = new Booking();



  }
}
