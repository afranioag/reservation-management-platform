package com.aag.authouser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthouserApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthouserApplication.class, args);
	}

}
