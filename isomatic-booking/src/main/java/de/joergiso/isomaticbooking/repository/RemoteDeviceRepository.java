package de.joergiso.isomaticbooking.repository;

import de.joergiso.isomaticbooking.domain.Device;
import de.joergiso.isomaticbooking.exception.DeviceNotFoundException;
import de.joergiso.isomaticbooking.service.ConfigurationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

  private ConfigurationService configurationService;

  @Autowired
  public RemoteDeviceRepository(ConfigurationService configurationService) {
    this.configurationService = configurationService;
  }

  public Device fetchDevice(Long deviceId) throws DeviceNotFoundException {
    ResponseEntity<List<Device>> response
        = restTemplate.exchange(
        configurationService.getDeviceEndpoint() + "/devices", HttpMethod.GET, null,
        new ParameterizedTypeReference<>() {
        }
    );
    return response.getBody()
        .stream()
        .filter(device -> deviceId.equals(device.getId()))
        .findFirst()
        .orElseThrow(DeviceNotFoundException::new);
  }

  public List<Device> fetchDevices() {
    ResponseEntity<List<Device>> response
        = restTemplate.exchange(
        configurationService.getDeviceEndpoint() + "/devices", HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Device>>() {}
    );
    return response.getBody();
  }
}
