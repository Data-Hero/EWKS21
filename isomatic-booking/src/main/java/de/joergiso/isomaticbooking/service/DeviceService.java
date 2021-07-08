package de.joergiso.isomaticbooking.service;

import de.joergiso.isomaticbooking.domain.Device;
import de.joergiso.isomaticbooking.exception.DeviceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeviceService {

  @Autowired
  @Qualifier(value = "bookingRestTemplate")
  private RestTemplate restTemplate;

  private ConfigurationService configurationService;

  @Autowired
  public DeviceService(ConfigurationService configurationService) {
    this.configurationService = configurationService;
  }

  public Device fetchDevice(Long deviceId) throws DeviceNotFoundException {
    ResponseEntity<List<Device>> response
        = restTemplate.exchange(
        configurationService.getDeviceEndpoint() + "/devices", HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Device>>() {}
    );
    return response.getBody()
        .stream()
        .filter(device -> deviceId.equals(device.getId()))
        .findFirst()
        .orElseThrow(DeviceNotFoundException::new);
  }

}
