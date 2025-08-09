Here is a sample `README.md` for your Spring Boot MongoDB Person API project. It covers setup, usage, API endpoints, validation, and testing.

---

# Spring Boot MongoDB Person API

A simple RESTful API for managing `Person` entities using Spring Boot, MongoDB, and Maven.  
Supports CRUD operations, validation, and Swagger documentation.

## Features

- Create, read, update, and delete `Person` records
- Field validation using Hibernate Validator
- MongoDB integration
- Automated getters/setters with Lombok
- API documentation with Swagger

## Technologies

- Java 8
- Spring Boot 2.7.x
- MongoDB
- Maven
- Lombok
- Hibernate Validator
- Swagger (Springfox)

## Prerequisites

- Java 8
- Maven
- MongoDB running locally or accessible remotely

## Setup

1. **Clone the repository**
   ```
   git clone <your-repo-url>
   cd springboot-mongodb-example
   ```

2. **Configure MongoDB**
    - Default connection is to `mongodb://localhost:27017`.
    - Change settings in `src/main/resources/application.properties` if needed.

3. **Build the project**
   ```
   mvn clean install
   ```

4. **Run the application**
   ```
   mvn spring-boot:run
   ```
   The API will be available at `http://localhost:8080`.

## API Endpoints

| Method | Endpoint              | Description                |
|--------|----------------------|----------------------------|
| POST   | `/api/persons`       | Create a new person        |
| GET    | `/api/persons/{id}`  | Get person by ID           |
| GET    | `/api/persons`       | List all persons           |
| DELETE | `/api/persons/{id}`  | Delete person by ID        |

### Example Request: Create Person

```json
POST /api/persons
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "mobileNo": "1234567890"
}
```

### Validation

- `name`: Required, 2-50 characters
- `email`: Required, valid email format
- `mobileNo`: Required, 10-15 characters

Validation errors return HTTP 400 with details.

### Swagger UI

API documentation is available at:  
`http://localhost:8080/swagger-ui.html`

## Testing

Run unit and integration tests with:
```
mvn test
```

## Project Structure

- `src/main/java/com/gsrao/mongodb/model/Person.java` — Person entity
- `src/main/java/com/gsrao/mongodb/controller/PersonController.java` — REST controller
- `src/main/java/com/gsrao/mongodb/service/PersonService.java` — Service layer
- `src/main/java/com/gsrao/mongodb/repository/PersonRepository.java` — MongoDB repository
- `src/main/java/com/gsrao/mongodb/exception/GlobalExceptionHandler.java` — Validation error handler

## Dependencies

Key dependencies in `pom.xml`:
- `spring-boot-starter-data-mongodb`
- `spring-boot-starter-web`
- `hibernate-validator`
- `lombok`
- `springfox-swagger2` and `springfox-swagger-ui`

## License

This project is licensed under the MIT License.

---

Save this as `README.md` in your project root.

## Running project from Command Line
-  To run your Spring Boot project from the command prompt on Windows:  
  -  Build the project using Maven:  
    - mvn clean install
run the application:  
      mvn spring-boot:run
      Or, if you have a packaged JAR (after build), use:  
      java -jar target/your-app-name.jar
      Replace your-app-name.jar with your actual JAR file name in the target folder.