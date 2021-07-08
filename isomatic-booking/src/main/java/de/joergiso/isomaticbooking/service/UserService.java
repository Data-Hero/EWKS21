package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.domain.User;
import de.joergiso.isomaticbooking.exception.UserNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

  private RestTemplate restTemplate;

  private ConfigurationService configurationService;

  @Autowired
  public UserService(RestTemplate restTemplate, ConfigurationService configurationService) {
    this.restTemplate = restTemplate;
    this.configurationService = configurationService;
  }

  public User fetchUser(Long userId) throws UserNotFoundException {
    ResponseEntity<List<User>> response
        = restTemplate.exchange(
        configurationService.getUserEndpoint()
            + "/user"
            + userId.toString(),
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<User>>() {}
    );
    return response.getBody()
        .stream()
        .filter(user -> userId.equals(user.getId()))
        .findFirst()
        .orElseThrow(UserNotFoundException::new);
  }
}
