package com.LatencyMGT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NetworkLatencyMgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetworkLatencyMgtApplication.class, args);
	}

}
