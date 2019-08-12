package com.stackroute.trackservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
public class TrackServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(TrackServiceApplication.class, args);
	}

}
