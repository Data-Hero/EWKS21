package de.joergiso.isomatic.device;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IsomaticDeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsomaticDeviceApplication.class, args);
	}

}
