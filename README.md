# ☕ java-prep

Repositorio para preparación de **entrevistas técnicas backend con Java y Spring Boot**.  
Incluye **apuntes, ejemplos prácticos y demos** de Java avanzado, diseño de software, DevOps básico y buenas prácticas para prepararte para entrevistas técnicas de Java.

---
⚠️ **Aviso:** Este repositorio está en proceso de construcción y se encuentra en constante actualización ⚠️

## 📌 Contenido

### 1. Fundamentos de Java
- Colecciones, Genéricos, Lambdas, Streams  
- Manejo de Excepciones  
- Concurrencia: `synchronized`, `volatile`, `ConcurrentHashMap`  
- `CompletableFuture`, `ExecutorService`, Virtual Threads
- Garbage Collector (visión general y tuning básico)  

### 2. Principios y Diseño de Software
- Principios **SOLID**  
- Patrones de diseño: Singleton, Factory, Builder, Strategy, Observer, Adapter, Decorator  
- Arquitectura en capas y Clean Architecture  
- Introducción a DDD (Domain Driven Design)  

### 3. Herramientas de Build y Control de Versiones
- Maven / Gradle (dependencias, profiles, plugins)  
- Git (branching, pull requests, conflictos, GitFlow)  

### 4. CI/CD y DevOps básico
- Pipelines (Jenkins, GitHub Actions, GitLab CI)  
- Docker (imágenes, volúmenes, redes)  
- Kubernetes (pods, deployments, services, config maps, secrets)  
- Infraestructura como código

### 5. Spring Core & Spring Boot
- IoC y DI (Inversión de Control, Inyección de Dependencias)  
- Beans, ciclos de vida y scopes  
- Starters y autoconfiguración  
- Configuración externalizada (properties, YAML)  
- Perfiles de entorno  
- Logging con SLF4J / Logback  

### 6. Desarrollo Web
- Spring MVC (Controllers, RequestMapping, ResponseEntity)  
- Validación (Bean Validation con `@Valid`, `@NotNull`, etc.)  
- Manejo de errores global (`@ControllerAdvice`, `@ExceptionHandler`)  

### 7. Persistencia
- JPA/Hibernate (entidades, relaciones, cascade, fetch types)  
- Repositorios: `CrudRepository`, `JpaRepository`, queries con `@Query` y Query Methods  
- Transacciones (`@Transactional`)  
- Migraciones con Flyway / Liquibase  
- Rendimiento: N+1 problem, batch inserts, caching  
- NoSQL: MongoDB, Redis  
- Cacheo con Spring Cache + Redis  

### 8. Comunicación entre Servicios
- Clientes HTTP: RestTemplate, WebClient  
- Resilience4j
- Kafka (producers, consumers, topics, consumer groups)  
- Event-driven architecture  
- API Gateway (Spring Cloud Gateway)  
- Service Registry (Eureka / Consul)  
- Config Server (Spring Cloud Config)  

### 9. Seguridad
- Spring Security (filtros, SecurityFilterChain)  
- Autenticación y autorización  
- JWT  
- Method Security (`@PreAuthorize`)  
- OAuth2 y OpenID Connect  
- Integración con Keycloak / Auth0  

### 10. Observabilidad
- Micrometer 
- Logging estructurado  
- Prometheus + Grafana  
- Tracing distribuido  

### 11. Asincronía y Scheduling
- `@Async`  
- `@Scheduled`  
- Colas de mensajes (RabbitMQ, Kafka)  

### 12. Testing
- Unit testing con JUnit 5 + Mockito  
- Integration testing con Spring Boot Test  
- Testcontainers (bases de datos, Kafka, RabbitMQ)  
- Contract Testing (Pact)  
- API Testing con Postman o REST Assured  
- Documentación de pruebas con Swagger / OpenAPI  

### 13. Buenas Prácticas
- Nomenclatura y organización de paquetes  
- Manejo de logs y trazabilidad  
- Clean Code  
- Principios de 12-factor app  
- Performance tuning  

---

## 🚀 Cómo usar este repo

- Cada tema tiene su propia carpeta con **apuntes** y **ejemplos**.  
- Los ejemplos están en **Java 21+** (incluyendo features de Java 21 como virtual threads).  
- Se incluyen casos prácticos y snippets.  

---

## 🎯 Objetivo

Este repositorio busca:  
- Servir como **guía de repaso** para entrevistas técnicas.  
- Tener a mano ejemplos y explicaciones de **temas avanzados de Java y Spring**.  
- Cubrir lo esencial de DevOps para entrevistas de backend.  

---

## 📖 Recursos recomendados

- *Effective Java* – Joshua Bloch  
- *Clean Code* – Robert C. Martin  
- *Spring in Action* – Craig Walls  
- Documentación oficial de [Java](https://docs.oracle.com/en/java/) y [Spring](https://spring.io/projects/spring-boot)  

---

✍️ **Autor**: @programando_con_jorge
📌 Proyecto en constante actualización mientras avanzo en mi preparación.
🤝 Este repositorio está abierto a mejoras y contribuciones.


