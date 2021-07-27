package de.joergiso.isomaticuser.repository;

import de.joergiso.isomatic.device.domain.unit.DeviceUnitDto;
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
  @Qualifier(value = "userRestTemplate")
  private RestTemplate restTemplate;

  public List<DeviceUnitDto> fetchDevices() {
    ResponseEntity<List<DeviceUnitDto>> response
        = restTemplate.exchange(
            "http://localhost:8082/device/devices",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<>() {
        }
    );
    return response.getBody();
  }
}
