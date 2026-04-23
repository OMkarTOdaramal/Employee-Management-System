# Employee Management System (Spring Boot REST API)

## Overview

This project is a **Spring Boot-based Employee Management System** developed to understand the design and implementation of **RESTful APIs**. It demonstrates how different HTTP methods interact with backend services and how a layered architecture improves maintainability and scalability.

The application follows a structured **Spring MVC architecture** and includes proper exception handling, DTO mapping, and database integration.

---

## Key Features

* Implementation of REST APIs using:

  * **GET** – Fetch employee data
  * **POST** – Create new employee
  * **PUT** – Update complete employee details
  * **PATCH** – Update partial employee data
  * **DELETE** – Remove employee

* Layered architecture:

  * Controller
  * Service
  * Repository
  * Entity
  * DTO

* Global Exception Handling for better error responses

* DTO ↔ Entity conversion using **ModelMapper**

* Integration with **MySQL Database**

* API testing using **Postman**

---

## Tech Stack

* Java
* Spring Boot
* Spring Web (REST API)
* Spring Data JPA
* MySQL
* ModelMapper
* Maven / Gradle

---

## Project Structure

```
src/main/java/com/yourpackage/
│
├── controller/     # Handles HTTP requests
├── service/        # Business logic layer
├── repository/     # Database interaction layer
├── entity/         # JPA entities (database models)
├── dto/            # Data Transfer Objects
├── exception/      # Custom exception handling
│
└── resources/
    └── application.properties
```

---

## API Endpoints

| Method | Endpoint        | Description               |
| ------ | --------------- | ------------------------- |
| GET    | /employees      | Get all employees         |
| GET    | /employees/{id} | Get employee by ID        |
| POST   | /employees      | Create new employee       |
| PUT    | /employees/{id} | Update employee (full)    |
| PATCH  | /employees/{id} | Update employee (partial) |
| DELETE | /employees/{id} | Delete employee           |

---

## Exception Handling

* Custom exceptions are implemented for scenarios like:

  * Employee not found
  * Invalid input data

* Global exception handler ensures consistent API responses

---

## Database Configuration

Configure your **MySQL** database in `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## How to Run the Project

1. Clone the repository

   ```
   git clone https://github.com/your-username/employee-management-system.git
   ```

2. Open in IDE (IntelliJ / Eclipse)

3. Configure MySQL database

4. Run the application

5. Test APIs using Postman

---

## Learning Outcomes

* Understanding of REST API design principles
* Hands-on experience with HTTP methods
* Implementation of layered architecture in Spring Boot
* Exception handling strategies
* DTO pattern and object mapping
* Database integration using JPA

---

## Future Enhancements

* Add validation using `@Valid`
* Implement pagination and sorting
* Add authentication (Spring Security / JWT)
* Deploy the application (AWS / Render / Railway)

---

## Author

Developed as part of hands-on learning to build real-world backend applications using Spring Boot.
