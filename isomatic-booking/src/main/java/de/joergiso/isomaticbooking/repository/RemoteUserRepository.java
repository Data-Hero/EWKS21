package de.joergiso.isomaticbooking.repository;

import de.joergiso.isomaticbooking.domain.User;
import de.joergiso.isomaticbooking.exception.UserNotFoundException;
import de.joergiso.isomaticbooking.service.ConfigurationService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RemoteUserRepository {

  private final ConfigurationService configurationService;

  private final UserRepository userRepository;

  @Autowired
  @Qualifier(value = "bookingRestTemplate")
  private RestTemplate restTemplate;

  @Autowired
  private CircuitBreakerFactory circuitBreakerFactory;

  @Autowired
  public RemoteUserRepository(ConfigurationService configurationService,
                              UserRepository userRepository) {
    this.configurationService = configurationService;
    this.userRepository = userRepository;
  }

  public User fetchUser(Long userId) throws UserNotFoundException {
    Optional<User> user = circuitBreakerFactory.create("fetchUser").run(() -> {
      ResponseEntity<User> response
          = restTemplate.exchange(
          configurationService.getUserEndpoint()
              + "/user/"
              + userId,
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<User>() { }
      );
      return Optional.ofNullable(response.getBody());
    }, t -> userRepository.findById(userId));
    user.ifPresent(userRepository::save);
    return user.orElseThrow(UserNotFoundException::new);
  }
}
