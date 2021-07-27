package de.joergiso.isomaticbooking.repository;

import de.joergiso.isomatic.device.domain.unit.DeviceUnitDto;
import de.joergiso.isomaticbooking.exception.DeviceNotFoundException;
import de.joergiso.isomaticbooking.service.ConfigurationService;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RemoteDeviceRepository {

  @Autowired
  @Qualifier(value = "bookingRestTemplate")
  private RestTemplate restTemplate;

  @Autowired
  private CircuitBreakerFactory circuitBreakerFactory;

  private final ConfigurationService configurationService;


  @Autowired
  public RemoteDeviceRepository(ConfigurationService configurationService) {
    this.configurationService = configurationService;
  }

  public List<DeviceUnitDto> fetchDevices() {
    ResponseEntity<String> response2
        = restTemplate.exchange(
        configurationService.getDeviceEndpoint()
            + "/devices",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<>() {
        }
    );
    ResponseEntity<List<DeviceUnitDto>> response
        = restTemplate.exchange(
        configurationService.getDeviceEndpoint()
            + "/devices",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<>() {
        }
    );
    return response.getBody();
  }
}
