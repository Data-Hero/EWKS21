package de.joergiso.isomaticbooking.repository;

import de.joergiso.isomaticbooking.domain.Device;
import de.joergiso.isomaticbooking.exception.DeviceNotFoundException;
import de.joergiso.isomaticbooking.service.ConfigurationService;
import java.util.Arrays;
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

  private final DeviceRepository deviceRepository;

  @Autowired
  public RemoteDeviceRepository(ConfigurationService configurationService,
                                DeviceRepository deviceRepository) {
    this.configurationService = configurationService;
    this.deviceRepository = deviceRepository;
  }

  public String fetchDevice(Long deviceId) throws DeviceNotFoundException {
    ResponseEntity<List<String>> response
        = restTemplate.exchange(
        configurationService.getDeviceEndpoint() + "/devices", HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {
        }
    );
    return response.getBody()
        .stream()
        .filter(device -> true) // TODO
        .findFirst()
        .orElseThrow(DeviceNotFoundException::new);
  }

  public List<String> fetchDevices() {
    Iterable<Device> devices = circuitBreakerFactory.create("fetchUser").run(() -> {
      ResponseEntity<List<Device>> response
          = restTemplate.exchange(
          configurationService.getUserEndpoint()
              + "/devices",
          HttpMethod.GET,
          null,
          new ParameterizedTypeReference<List<Device>>() {
          }
      );
      return response.getBody();
    }, t -> deviceRepository.findAll());
    devices.forEach(deviceRepository::save);
    return StreamSupport.stream(devices.spliterator(), false).collect(Collectors.toList());
  }
}
