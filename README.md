
# Library Management System - Backend Server

This backend server for the Library Management System is developed using Spring Boot and provides essential RESTful APIs for handling authentication, customer management, book management, and order management functionalities. It interacts with a MySQL database for data persistence.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup and Installation](#setup-and-installation)
- [Database Configuration](#database-configuration)
- [API Endpoints](#api-endpoints)
  - [Authentication Endpoints](#authentication-endpoints)
  - [Customer Endpoints](#customer-endpoints)
  - [Book Endpoints](#book-endpoints)
  - [Order Endpoints](#order-endpoints)
- [Running the Server](#running-the-server)

## Features

- **User Authentication**: Supports role-based authentication for `admin` and `customer` roles.
- **Data Management**: Create, read, update, and delete functionalities for books, customers, and orders.
- **Role-based Access Control**: Secured routes accessible by specific roles (admin or customer).
- **CORS Configuration**: Configured to allow requests from the frontend.
- **Validation**: Basic validation of user inputs in requests.

## Technologies Used

- **Spring Boot**
- **MySQL**
- **Spring Data JPA**
- **Spring Security**
- **Java Persistence API (JPA)**

## Project Structure

```
src
│
├── main
│   ├── java/com/projectone/librarymanagement
│   │   ├── controller       # API Controllers for each entity
│   │   ├── entity           # Entity classes representing database tables
│   │   ├── repository       # Repository interfaces for data persistence
│   │   ├── service          # Service layer containing business logic
│   │   └── LibraryManagementApplication.java # Main Spring Boot application
│   └── resources
│       ├── application.properties # Application configuration file
│       └── data.sql               # Initial database setup script (optional)
└── test
    └── java/com/projectone/librarymanagement # Unit and integration tests
```

## Setup and Installation

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd library-management-backend
   ```

2. **Configure MySQL Database**

   Ensure MySQL is running, and update the `application.properties` file with your database credentials.

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/library_management
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build the Project**

   ```bash
   mvn clean install
   ```

## Database Configuration

The application uses MySQL as the primary database. Create a MySQL database named `library_management`, and configure the connection properties in `application.properties`.

## API Endpoints

### Authentication Endpoints

- **POST /api/auth/login** - Logs in a user and returns the role if credentials are valid.
- **POST /api/auth/register** - Registers a new customer account.

### Customer Endpoints

- **GET /api/customers** - Retrieves all customers.
- **GET /api/customers/{id}** - Retrieves a specific customer by ID.
- **POST /api/customers** - Adds a new customer.
- **PUT /api/customers/{id}** - Updates an existing customer.
- **DELETE /api/customers/{id}** - Deletes a customer.

### Book Endpoints

- **GET /api/books** - Retrieves all books.
- **GET /api/books/{id}** - Retrieves a specific book by ID.
- **POST /api/books** - Adds a new book.
- **PUT /api/books/{id}** - Updates an existing book.
- **DELETE /api/books/{id}** - Deletes a book.

### Order Endpoints

- **GET /api/orders** - Retrieves all orders.
- **GET /api/orders/{id}** - Retrieves a specific order by ID.
- **POST /api/orders** - Creates a new order.
- **PUT /api/orders/{id}** - Updates an existing order.
- **DELETE /api/orders/{id}** - Deletes an order.

## Running the Server

To start the backend server, run:

```bash
mvn spring-boot:run
```

The backend server will run on `http://localhost:8080`. Ensure your frontend is configured to communicate with this base URL.

---

