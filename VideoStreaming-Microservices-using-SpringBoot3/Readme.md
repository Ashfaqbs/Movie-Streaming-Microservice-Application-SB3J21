## VideoStreaming-Microservices-using-SpringBoot3

![alt text](image-3.png)


### UI View

![alt text](image-4.png)


## DB load 

![alt text](image-5.png)

## Actual movie data 

![alt text](image-6.png)


Note :to use spring cloud dependencies check out the spring cloud support version https://spring.io/projects/spring-cloud

eg : 

```
-- Eureka server 
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>



<properties>
		<java.version>21</java.version>
		<spring-cloud.version>2023.0.3</spring-cloud.version>
	</properties>


        <dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-dependencies</artifactId>
		<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>



```