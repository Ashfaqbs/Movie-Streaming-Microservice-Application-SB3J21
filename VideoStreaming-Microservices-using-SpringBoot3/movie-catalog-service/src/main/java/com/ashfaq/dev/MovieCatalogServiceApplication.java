package com.ashfaq.dev;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieCatalogServiceApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
