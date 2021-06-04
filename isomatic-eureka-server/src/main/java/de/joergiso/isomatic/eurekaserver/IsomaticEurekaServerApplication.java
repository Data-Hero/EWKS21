package de.joergiso.isomatic.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class IsomaticEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsomaticEurekaServerApplication.class, args);
	}

}
