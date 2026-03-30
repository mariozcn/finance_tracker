# Finance Tracker – User Module

## Introduction

This module provides basic user management functionality for a finance tracking application. It is built with Spring Boot and exposes a simple REST API for creating and storing users in a relational database.

The goal of this module is to serve as a clean prototype foundation that can be extended with authentication, validation, and additional business logic.

---

## Table of Contents

* Introduction
* Features
* Technologies
* Project Structure
* Installation
* Usage
* API Endpoints
* Configuration
* Examples
* Future Improvements
* License

---

## Features

* Create users via REST API
* Persist user data using JPA
* Enforce unique email addresses
* Default currency support (RON)
* Layered architecture (Controller → Service → Repository)

---

## Technologies

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Jakarta Persistence API
* Relational Database (PostgreSQL, MySQL, or H2)

---

## Project Structure

```plaintext
com.example.finance_tracker.user
│
├── User.java              # Entity class
├── UserController.java    # REST controller
├── UserService.java       # Business logic
└── UserRepository.java    # Data access layer
```

---

## Installation

### Prerequisites

* Java 17 or higher
* Maven
* A running database instance (optional if using H2)

### Steps

```bash
git clone https://github.com/your-username/finance-tracker.git
cd finance-tracker
mvn clean install
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## Usage

The user API is available at:

```
/api/users/
```

You can interact with it using tools like Postman, curl, or any HTTP client.

---

## API Endpoints

### Create User

**POST** `/api/users/`

#### Request Body

```json
{
  "email": "user@example.com",
  "passwordHash": "hashed_password",
  "currencyCode": "RON",
  "createdAt": "2026-03-30T12:00:00"
}
```

#### Response

```json
{
  "id": 1,
  "email": "user@example.com",
  "passwordHash": "hashed_password",
  "currencyCode": "RON",
  "createdAt": "2026-03-30T12:00:00"
}
```

---

## Configuration

Example `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/finance_tracker
spring.datasource.username=your_user
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## Examples

### cURL

```bash
curl -X POST http://localhost:8080/api/users/ \
-H "Content-Type: application/json" \
-d '{
  "email": "test@example.com",
  "passwordHash": "123456",
  "currencyCode": "RON",
  "createdAt": "2026-03-30T12:00:00"
}'
```

---

## Future Improvements

* Authentication and authorization
* Password hashing and security
* Input validation using DTOs
* Global exception handling
* Additional endpoints (update, delete, fetch users)
* Pagination and filtering support

---

## License

This project is licensed under the MIT License.
