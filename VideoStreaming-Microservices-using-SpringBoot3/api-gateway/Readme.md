# API Gateway
- An API Gateway is an essential component in a microservices architecture. It acts as a single entry point for all client requests to various backend services. The API Gateway abstracts the complexity of the underlying microservices by providing a unified interface to clients. It also handles various cross-cutting concerns such as authentication, authorization, logging, rate limiting, and more.


- Key Responsibilities of an API Gateway
 1. Request Routing: Directs client requests to the appropriate backend services.
2. Load Balancing: Distributes incoming requests across multiple instances of backend services.
3. Authentication and Authorization: Validates user credentials and permissions before forwarding requests to backend services.
4. Rate Limiting: Controls the number of requests a client can make to prevent abuse.
5. API Composition: Combines responses from multiple backend services into a single response for the client.
6. Caching: Stores responses to reduce load on backend services and improve response times.
7. Logging and Monitoring: Tracks requests and responses for auditing and debugging purposes.



- Why Use an API Gateway?
1. Simplified Client Interface: Clients interact with a single endpoint instead of multiple services.
2. Centralized Security: Apply security policies in one place rather than in each microservice.
3. Reduced Client Complexity: Clients do not need to handle service discovery or multiple endpoints.
4. Performance Optimization: Implement caching and rate limiting to enhance performance and protect backend services.

- How API Gateway Works
1. Client Request: The client sends a request to the API Gateway.
2. Gateway Processing: The API Gateway processes the request, performing tasks like authentication, rate limiting, and request transformation.
3. Service Routing: The API Gateway routes the request to the appropriate backend service.
4. Backend Response: The backend service processes the request and sends the response back to the API Gateway.
5. Response Handling: The API Gateway may perform response transformations or aggregations before sending the final response to the client.


- API Gateway Technologies

Several technologies and tools can be used to implement an API Gateway, such as:

1. Spring Cloud Gateway: Built on Spring Framework, integrates well with other Spring Cloud components.
2. Netflix Zuul: Part of the Netflix OSS stack, provides routing and filtering capabilities.
3. Kong: An open-source API Gateway with a rich plugin ecosystem.
4. NGINX: A web server that can be configured to act as an API Gateway.
5. AWS API Gateway: A fully managed service by Amazon Web Services.


## Create a Springboot project 

- add the following dependencies 

```
--API gateway dependency 

    <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-gateway-mvc</artifactId>
		</dependency>

--To regsiter with service discovery

		<dependency>
			<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>

--Devtools Optional
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

```

- Configurations



```
1. @EnableDiscoveryClient this to the main class to register to eureka

2. Cors allowing

	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedHeaders("*")
						.allowedOrigins("*");
			}
		};
	}



3 Application.prop file


server.port=8080

eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka




## API Gateway configurations

#Registering movie-catalog-service
#name
spring.cloud.gateway.mvc.routes[0].id=movie-catalog-service
#url
spring.cloud.gateway.mvc.routes[0].uri=http://localhost:8090
#predicates like when to invoke the url so when the path is /movie-info/** it will be invoked
spring.cloud.gateway.mvc.routes[0].predicates[0]=Path=/movie-Info/**





#Registering movie-streaming-service
#name
spring.cloud.gateway.mvc.routes[1].id=movie-streaming-service
#url
spring.cloud.gateway.mvc.routes[1].uri=http://localhost:8091
#predicates like when to invoke the url so when the path is /stream/** the api starting with /stream will be invoked
spring.cloud.gateway.mvc.routes[1].predicates[0]=Path=/stream/**






```

###  Result : 



```

ORG url : 

http://localhost:8090/movie-Info/2
http://localhost:8090/movie-Info/list

API gateway url :

http://localhost:8080/movie-Info/2
http://localhost:8080/movie-Info/list

same for streaming service 

```

