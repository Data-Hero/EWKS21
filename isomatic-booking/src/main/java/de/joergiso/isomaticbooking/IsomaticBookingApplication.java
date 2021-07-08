package de.joergiso.isomaticbooking;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class IsomaticBookingApplication {

  public static void main(String[] args) {
    SpringApplication.run(IsomaticBookingApplication.class, args);
  }

  @Bean("bookingRestTemplate")
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
