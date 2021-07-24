package de.joergiso.isomaticbooking.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

  @Value("${foo.bar:http://localhost:8082}")
  private String deviceEndpoint;
  @Value("${foo.bar:http://localhost:8083}")
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