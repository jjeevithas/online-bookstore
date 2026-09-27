# Online Bookstore - Full Stack Java Project

A simple full-stack online bookstore built with HTML, CSS, JavaScript, Spring MVC/REST, JDBC and MySQL.

## Features
- Homepage with books
- Search by title or author
- Book details page
- Add to cart
- Remove from cart
- Cart total calculation
- Checkout and order confirmation
- MySQL database through JDBC
- Responsive frontend
- Book cover images

## Technologies
- Frontend: HTML5, CSS3, JavaScript
- Backend: Java 17, Spring Boot, Spring Web MVC / REST
- Database: MySQL
- Database access: Spring JDBC (JdbcTemplate)
- Build: Maven
- IDE: VS Code

## API Endpoints
- GET `/books`
- GET `/books?search=java`
- GET `/books/{id}`
- POST `/cart` body: `{"bookId":1}`
- GET `/cart`
- DELETE `/cart/{id}`
- POST `/checkout`

## Setup in VS Code

### 1. Install
Install JDK 17, VS Code, Extension Pack for Java, Maven and MySQL.

### 2. Create database
Open MySQL and run:
```sql
CREATE DATABASE bookstore;
```

Then check `src/main/resources/application.properties`.
Default settings are:
- username: root
- password: root

Change the password if your MySQL installation uses a different password.

### 3. Run
Open this folder in VS Code terminal:
```bash
mvn clean spring-boot:run
```

Open:
`http://localhost:8081`

### 4. Alternative
You can also run `OnlineBookstoreApplication.java` using the VS Code Run button.

## Project Structure
- `src/main/java/com/bookstore/controller` - REST controllers
- `src/main/java/com/bookstore/service` - business logic
- `src/main/java/com/bookstore/dao` - JDBC database operations
- `src/main/java/com/bookstore/model` - Java model classes
- `src/main/resources/static` - frontend
- `schema.sql` - database tables
- `data.sql` - sample books

## Notes
The login/signup feature is intentionally not included because it is optional in the assignment. It can be added later using users, sessions/JWT, password hashing and validation.
