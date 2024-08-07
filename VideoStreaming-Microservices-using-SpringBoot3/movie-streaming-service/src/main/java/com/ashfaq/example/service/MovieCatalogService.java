package com.ashfaq.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieCatalogService {

	public static final String CATALOG_SERVICE = "http://movie-catalog-service";
	//as we had provided the loadbalanced , the rest template will call the 
	//one optimal instance of the catalog service application
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	public String getMoviePath(long id) {
		
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(CATALOG_SERVICE+"/movie-Info/"+id, String.class);
		
		return responseEntity.getBody();

	}
}
