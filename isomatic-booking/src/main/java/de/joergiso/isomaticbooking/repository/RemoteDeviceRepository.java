package de.joergiso.isomaticbooking.repository;

import de.joergiso.isomatic.device.domain.unit.DeviceUnitDto;
import de.joergiso.isomaticbooking.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class RemoteDeviceRepository {

  @Autowired
  @Qualifier(value = "bookingRestTemplate")
  private RestTemplate restTemplate;

  private final ConfigurationService configurationService;


  @Autowired
  public RemoteDeviceRepository(ConfigurationService configurationService) {
    this.configurationService = configurationService;
  }

  public List<DeviceUnitDto> fetchDevices() {
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
