package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.domain.User;
import de.joergiso.isomaticbooking.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

  @Autowired
  @Qualifier(value = "bookingRestTemplate")
  private RestTemplate restTemplate;

  private ConfigurationService configurationService;


  @Autowired
  public UserService(ConfigurationService configurationService) {
    this.configurationService = configurationService;
  }

  public User fetchUser(Long userId) throws UserNotFoundException {
    ResponseEntity<User> response
        = restTemplate.exchange(
        configurationService.getUserEndpoint()
            + "/userservice/user/"
            + userId.toString(),
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<User>() {}
    );
    User user = response.getBody();
    if (user == null) {
      throw new UserNotFoundException();
    }
    return user;
  }
}
