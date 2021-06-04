package de.joergiso.isomaticuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IsomaticUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsomaticUserApplication.class, args);
	}

}
