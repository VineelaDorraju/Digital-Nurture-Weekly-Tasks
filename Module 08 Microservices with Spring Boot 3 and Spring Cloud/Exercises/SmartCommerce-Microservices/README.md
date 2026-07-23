# Smart Commerce Microservices

An enterprise-level **Spring Boot 3 + Spring Cloud** microservices project that demonstrates distributed system design, service discovery, centralized configuration, API Gateway, event-driven communication, security, monitoring, caching, and fault-tolerant architecture.

---

## Overview

This project simulates an online commerce platform where independent microservices collaborate to process customer orders. Every service owns its own responsibility and communicates through REST APIs, OpenFeign clients, and Apache Kafka.

---

## Technology Stack

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming Language |
| Spring Boot 3 | Microservice Framework |
| Spring Cloud | Distributed System Support |
| Spring Cloud Gateway | API Gateway |
| Netflix Eureka | Service Discovery |
| Spring Cloud Config | Centralized Configuration |
| Spring Security | Authentication & Authorization |
| JWT | Token-based Security |
| OpenFeign | Inter-service Communication |
| Apache Kafka | Event Streaming |
| Spring Data JPA | Database Access |
| MySQL | Relational Database |
| Spring Cache | Performance Optimization |
| Spring Boot Actuator | Monitoring |
| Prometheus | Metrics Collection |
| Grafana | Visualization |
| Elasticsearch | Log Storage |
| Logstash | Log Processing |
| Kibana | Log Analytics |
| Docker Compose | Infrastructure Deployment |
| Maven | Build Tool |

---

# Project Architecture

```
                        Config Server
                              │
                              ▼
                        Eureka Server
                              │
     ┌────────────────────────┼─────────────────────────┐
     ▼                        ▼                         ▼
API Gateway             Auth Service             User Service
     │
     ▼
Product Service ────────────────┐
     │                          │
     ▼                          ▼
Inventory Service         Order Service
                                 │
                                 ▼
                          Payment Service
                                 │
                                 ▼
                      Notification Service

───────────────────────────────────────────────────────

Kafka • MySQL • Prometheus • Grafana
Elasticsearch • Logstash • Kibana
```

---

# Microservices

## Config Server

Centralized configuration management for every microservice.

### Responsibilities

- Externalized configuration
- Environment-specific properties
- Central configuration repository

---

## Eureka Server

Acts as the service registry.

### Responsibilities

- Service registration
- Service discovery
- Health management

---

## API Gateway

Single entry point for client requests.

### Responsibilities

- Request routing
- JWT validation
- Authentication forwarding
- Request filtering

---

## Authentication Service

Responsible for user authentication.

### Features

- Login
- JWT Token Generation
- Token Validation
- User Authentication

---

## User Service

Handles user management.

### Features

- Register User
- Update User
- Delete User
- Search Users
- Role Management

---

## Product Service

Maintains product information.

### Features

- Add Product
- Product Search
- Product Availability
- Stock Updates
- Product Cache

---

## Inventory Service

Maintains inventory information.

### Features

- Inventory Tracking
- Stock Reservation
- Inventory Updates

---

## Order Service

Coordinates order processing.

### Features

- Create Order
- Cancel Order
- Saga Orchestration
- Distributed Transactions

---

## Payment Service

Processes customer payments.

### Features

- Payment Processing
- Refund Management
- Payment Events

---

## Notification Service

Consumes Kafka events.

### Features

- Order Notifications
- Payment Notifications
- Email Simulation

---

# Communication Pattern

## Synchronous

- REST APIs
- OpenFeign Clients

## Asynchronous

- Apache Kafka
- Event-driven Messaging

---

# Kafka Events

- order-created
- order-completed
- order-cancelled
- payment-success
- payment-failed
- payment-refunded

---

# Security

- Spring Security
- JWT Authentication
- OAuth Configuration
- Authorization Filter
- Secure REST APIs

---

# Design Patterns

- Microservices Architecture
- API Gateway Pattern
- Service Registry Pattern
- Saga Pattern
- Repository Pattern
- DTO Pattern
- Dependency Injection
- Event-driven Architecture

---

# Monitoring

Spring Boot Actuator exposes runtime metrics.

Prometheus collects application metrics.

Grafana visualizes dashboards.

ELK Stack provides centralized log management.

---

# Caching

Spring Cache is used to improve performance by reducing database calls for frequently accessed product information.

---

# Fault Tolerance

The application is designed to support:

- Retry Mechanism
- Circuit Breaker
- Service Discovery
- Distributed Transactions

---

# Docker Infrastructure

The project uses Docker Compose to start:

- MySQL
- Kafka
- ZooKeeper
- Elasticsearch
- Logstash
- Kibana
- Prometheus
- Grafana



# Default Ports

| Service | Port |
|----------|------|
| Config Server | 8888 |
| Eureka Server | 8761 |
| API Gateway | 8080 |
| Auth Service | 8081 |
| Product Service | 8082 |
| Inventory Service | 8083 |
| Order Service | 8084 |
| Payment Service | 8085 |
| Notification Service | 8086 |
| User Service | 8087 |
| Prometheus | 9090 |
| Grafana | 3000 |
| Kibana | 5601 |
| Elasticsearch | 9200 |
| Kafka | 9092 |
| MySQL | 3306 |

---

# Enterprise Features

- Spring Boot 3
- Spring Cloud
- Distributed Architecture
- RESTful APIs
- Service Discovery
- Centralized Configuration
- API Gateway
- JWT Security
- OpenFeign Clients
- Kafka Messaging
- Saga Pattern
- Caching
- Monitoring
- ELK Logging
- Docker Support

---

# Future Enhancements

- Redis Cache
- Kubernetes Deployment
- CI/CD Pipeline
- Zipkin Distributed Tracing
- Resilience4j Circuit Breaker
- OAuth2 Authorization Server
- RabbitMQ Integration

---

# Author

**Smart Commerce Microservices**

Spring Boot 3 + Spring Cloud Enterprise Microservices Demonstration Project.