package de.joergiso.isomaticuser.repository;


import de.joergiso.isomaticuser.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
