# learning-springboot-ms-currency-conversion-service

# Currency Conversion Microservice

A Spring Boot microservice that converts currency amounts using exchange rates from a Currency Exchange Service.

## Overview

This service consumes the Currency Exchange Service to perform currency conversions. It demonstrates microservice communication using Spring Cloud Feign Client.

## Tech Stack

- **Spring Boot** - Application framework
- **Spring Cloud OpenFeign** - Declarative REST client
- **Spring Cloud Netflix Eureka** - Service discovery
- **Maven** - Dependency management
- **Java 17+**

## Architecture

```
Currency Conversion Service (Port: 8100)
    ↓ (Feign Client)
Currency Exchange Service (Port: 8000)
    ↓
Eureka Naming Server (Port: 8761)
```

## Prerequisites

- JDK 17 or higher
- Maven 3.6+
- Currency Exchange Service running on port 8000
- Eureka Server running on port 8761 (optional)

## Quick Start

### 1. Clone & Build
```bash
git clone https://github.com/Adhito/learning-springboot-ms-currency-conversion-service.git
cd learning-springboot-ms-currency-conversion-service
mvn clean install
```

### 2. Run Application
```bash
mvn spring-boot:run
```

### 3. Access Service
```
http://localhost:8100
```

## API Endpoints

### Convert Currency
```http
GET /currency-conversion/from/{from}/to/{to}/quantity/{quantity}
```

**Example:**
```bash
curl http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/1000
```

**Response:**
```json
{
  "id": 10001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 83.50,
  "quantity": 1000,
  "totalCalculatedAmount": 83500.00,
  "port": 8000
}
```

### Using Feign Client
```http
GET /currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}
```

## Configuration

### application.properties
```properties
spring.application.name=currency-conversion-service
server.port=8100

# Eureka Configuration
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

# Currency Exchange Service URL
currency-exchange-service.ribbon.listOfServers=http://localhost:8000,http://localhost:8001
```

## Key Components

| Component | Description |
|-----------|-------------|
| `CurrencyConversionController` | REST API endpoints |
| `CurrencyExchangeServiceProxy` | Feign client for exchange service |
| `CurrencyConversion` | DTO for request/response |
| `SpringBootApplication` | Main application class with `@EnableFeignClients` |

## Features

- ✅ Currency conversion via REST API
- ✅ Feign Client for service-to-service communication
- ✅ Client-side load balancing with Ribbon
- ✅ Service discovery with Eureka
- ✅ Fault tolerance and resilience

## Dependencies

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

## Testing

```bash
# Run tests
mvn test

# Run with coverage
mvn clean test jacoco:report
```

## Docker Support

```bash
# Build image
docker build -t currency-conversion-service .

# Run container
docker run -p 8100:8100 currency-conversion-service
```

## Related Services

- [Currency Exchange Service](https://github.com/Adhito/learning-springboot-ms-currency-exchange-service)
- [Eureka Naming Server](https://github.com/Adhito/learning-springboot-ms-naming-server)

## Troubleshooting

**Service not connecting to Exchange Service:**
- Ensure Currency Exchange Service is running on port 8000
- Check network connectivity
- Verify Eureka registration

**Port already in use:**
```bash
# Change port in application.properties
server.port=8101
```

## License

MIT License

## Author

[Adhito](https://github.com/Adhito)

---

📚 **Learning Resources:**
- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)
- [Microservices with Spring Boot](https://www.springboottutorial.com/creating-microservices-with-spring-boot-part-1-getting-started)