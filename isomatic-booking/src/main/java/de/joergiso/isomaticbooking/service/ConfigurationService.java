package de.joergiso.isomaticbooking.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

  @Value("${deviceEndpoint:http://localhost:8082/device}")
  private String deviceEndpoint;
  @Value("${userEndpoint:http://localhost:8083/userservice}")
  private String userEndpoint;

  public String getDeviceEndpoint() {
    return deviceEndpoint;
  }

  public void setDeviceEndpoint(String deviceEndpoint) {
    this.deviceEndpoint = deviceEndpoint;
  }

  public String getUserEndpoint() {
    return userEndpoint;
  }

  public void setUserEndpoint(String userEndpoint) {
    this.userEndpoint = userEndpoint;
  }
}
