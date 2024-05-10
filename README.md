# Spring Boot, Spring Security, PostgreSQL: JWT Authentication & Authorization example

## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`

```
spring.datasource.url= jdbc:postgresql://localhost:5432/testdb
spring.datasource.username= postgres
spring.datasource.password= root

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update

# App Properties
bezkoder.app.jwtSecret= ======================Kevin=Spring===========================
bezkoder.app.jwtExpirationMs= 86400000
```

## Run Spring Boot application
```
mvn spring-boot:run
```

## I used data loader to initialize the data in postgres, so you only need to new the database first and confirm the account and password of the database.
```
CREATE DATEBASE testdb;
```