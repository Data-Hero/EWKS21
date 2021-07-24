package de.joergiso.isomaticbooking.repository;

import de.joergiso.isomaticbooking.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
