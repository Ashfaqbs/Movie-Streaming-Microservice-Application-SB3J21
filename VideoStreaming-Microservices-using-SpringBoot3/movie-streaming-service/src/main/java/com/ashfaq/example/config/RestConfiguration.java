package com.ashfaq.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

	
	@LoadBalanced//loadbalance is attached to rest template
	@Bean//communication between microservices
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
