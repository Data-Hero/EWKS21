package de.joergiso.isomaticbooking.repository;

import de.joergiso.isomaticbooking.domain.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
