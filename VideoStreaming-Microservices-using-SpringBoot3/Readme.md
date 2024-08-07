## VideoStreaming-Microservices-using-SpringBoot3

# Movie Streaming Microservice Architecture Application

- This project is a video streaming application built using a microservice architecture with Spring Boot 3 and Java 21. The architecture is designed to be highly modular, scalable, and maintainable, leveraging several key Spring Cloud components.

## Architecture Overview:

- API Gateway: Acts as the single entry point for all client requests, managing and routing them to the appropriate microservices. It handles requests from both Postman for testing and an HTML WebApp for user interaction.

- Business Logic Layer: Comprises two main microservices:

- Movie-Catalog Service: Responsible for managing the catalog of movies, including metadata like titles, descriptions, and ratings.
- Movie-Streaming Service: Handles the streaming of video content, ensuring seamless delivery to users.
- Service Communication: Microservices communicate with each other using service-to-service communication protocols, ensuring data consistency and reliability.

- Supporting Services:

- Service Registry (Eureka): Enables service discovery, allowing microservices to find and communicate with each other dynamically.
- Config Server: Centralized configuration management for all microservices, ensuring consistency and ease of updates.
- Zipkin: Distributed tracing system for monitoring and troubleshooting latency issues and bottlenecks within the microservice architecture.


This architecture ensures high availability, fault tolerance, and easy scalability, making it suitable for handling a large number of concurrent users and a vast library of video content

![alt text](image-3.png)


### UI View

![alt text](image-4.png)


## DB load 

![alt text](image-5.png)

## Actual movie data 

![alt text](image-6.png)
