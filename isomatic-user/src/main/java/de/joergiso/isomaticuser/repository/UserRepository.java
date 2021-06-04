package de.joergiso.isomaticuser.repository;


import de.joergiso.isomaticuser.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
