# User Management REST API

This is a simple RESTful API built using **Spring Boot** and **MySQL** that provides basic CRUD (Create, Read, Update, Delete) operations for managing users.

## Technologies Used
- **Backend Framework**: Spring Boot
- **Database**: MySQL
- **Programming Language**: Java
- **Build Tool**: Maven
- **Validation**: Jakarta Validation API
- **Error Handling**: Custom Exception Handling
- **API Documentation**: Swagger UI (Springdoc OpenAPI)

## Features
- Create a User: Accepts name, email, and age, then stores them in a database.
- Retrieve All Users: Returns a list of users.
- Retrieve a Single User: Fetches a user by ID.
- Update a User: Updates user details using an ID.
- Delete a User: Removes a user from the database using an ID.
- API Documentation via Swagger UI.

---

## Setup Instructions

### Prerequisites
Ensure you have the following installed:
- **Java 17+**
- **Maven** (for dependency management)
- **MySQL Database**
- **Postman or Curl** (for API testing, optional)

### Installation Steps

1. **Clone the repository**
   ```sh
   git clone https://github.com/abhigorde15/user_crud_apis.git
   cd user_crud_apis
   ```

2. **Configure Database**
   - Open MySQL and create a database:
     ```sql
     CREATE DATABASE user_management;
     ```
   - Update `src/main/resources/application.properties` with your database credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/user_management
     spring.datasource.username=root
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build and Run the Application**
   ```sh
   mvn spring-boot:run
   ```
   The server will start at `http://localhost:8081`.

---

## API Documentation (Swagger UI)

This project includes Swagger UI for API documentation and testing.

### Access Swagger UI
Once the application is running, open the following URL in your browser:
```
http://localhost:8081/swagger-ui/index.html
```

### OpenAPI Specification
The OpenAPI JSON specification can be accessed at:
```
http://localhost:8081/v3/api-docs
```

---

## API Endpoints

### 1. Create a User
**Endpoint:** `POST /api/users`
- **Request Body:**
  ```json
  {
    "name": "Xyz",
    "email": "xyz@example.com",
    "age": 30
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "name": "Xyz",
    "email": "xyz@example.com",
    "age": 30
  }
  ```

### 2. Retrieve All Users
**Endpoint:** `GET /api/users`
- **Response:**
  ```json
  [
    {
      "id": 1,
      "name": "Xyz",
      "email": "xyz@example.com",
      "age": 30
    },
    {
      "id": 2,
      "name": "Abc",
      "email": "abc@example.com",
      "age": 25
    }
  ]
  ```

### 3. Retrieve a Single User
**Endpoint:** `GET /api/users/{id}`
- **Response:**
  ```json
  {
    "id": 1,
    "name": "Xyz",
    "email": "xyz@example.com",
    "age": 30
  }
  ```

### 4. Update a User
**Endpoint:** `PUT /api/users/{id}`
- **Request Body:**
  ```json
  {
    "name": "Xyz Updated",
    "email": "xyzupdated@example.com",
    "age": 35
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "name": "Xyz Updated",
    "email": "xyzupdated@example.com",
    "age": 35
  }
  ```

### 5. Delete a User
**Endpoint:** `DELETE /api/users/{id}`
- **Response:**
  ```json
  {
    "message": "User deleted successfully"
  }
  ```

---

## Error Handling
| Scenario | HTTP Status Code | Response Example |
|----------|-----------------|------------------|
| User not found | 404 Not Found | `{ "message": "User with ID not found" }` |
| Email already exists | 409 Conflict | `{ "message": "User with email already exists" }` |
| Invalid input (e.g., negative age) | 400 Bad Request | `{ "message": "Invalid input" }` |

---

## Contact
For any inquiries, please contact abhishekgorde777@gmail.com.

