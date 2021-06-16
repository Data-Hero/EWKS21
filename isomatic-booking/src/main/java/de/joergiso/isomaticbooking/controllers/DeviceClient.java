package de.joergiso.isomaticbooking.controllers;

import de.joergiso.isomaticbooking.domain.Function;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DeviceClient {

  //@Autowired
  //private RestTemplate restTemplate;

  //@Value("${functionbundle.endpoint}")
  //private String endpoint;

  public List<Function> fetchFunctions() {
    //ResponseEntity<List<Function>> response
    //    = restTemplate.exchange(
    //    "http://anmeldungservice" + endpoint, HttpMethod.GET, null,
    //    new ParameterizedTypeReference<List<Function>>() {}
    //);
    //return response.getBody();
    return null;
  }

}
