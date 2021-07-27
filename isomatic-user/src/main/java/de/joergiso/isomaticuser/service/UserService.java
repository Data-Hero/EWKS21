package de.joergiso.isomaticuser.service;

import de.joergiso.isomaticuser.domain.User;
import de.joergiso.isomaticuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }

    public User getUserById(Long id) {
        Optional<User> user = this.userRepository.findById(id);

        return user.orElse(null);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public void updateUser(User user) {
        Optional<User> storedUser = this.userRepository.findById(user.getId());

        storedUser.ifPresent(entity -> {
            entity.setName(user.getName());
            entity.setBookings(user.getBookings());
            entity.setDevices(user.getDevices());

            this.userRepository.save(entity);
        });
    }
}
