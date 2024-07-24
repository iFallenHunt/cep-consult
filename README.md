[🇧🇷️](README-PTBR.md)

# Postal Code API Project

## Table of Contents
- [Overview](#overview)
- [Project Structure](#project-structure)
    - [Packages](#packages)
    - [Main Classes](#main-classes)
- [Database DER Diagram](#database-der-diagram)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
- [Usage](#usage)
    - [Endpoints](#endpoints)
- [Technologies Used](#technologies-used)

## Overview
The Postal Code API Project is a Spring Boot application that provides a RESTful API for managing clients and their addresses. It integrates with the ViaCep service to retrieve address details based on postal codes (CEPs).

## Project Structure

### Packages
```
com.tech.postal_code
├── controller
│   └── ClientRestController.java
├── model
│   ├── Address.java
│   └── Client.java
├── repository
│   ├── AddressRepository.java
│   └── ClientRepository.java
├── service
│   ├── ClientService.java
│   ├── ViaCepService.java
│   └── impl
│       └── ClientServiceImpl.java
├── error
│   ├── ApiError.java
│   ├── ApiExceptionHandler.java
│   └── ClientNotFoundException.java
└── ApiProjectApplication.java
```

### Main Classes
- **ClientRestController.java**: Defines the REST endpoints for client operations.
- **Address.java**: Entity representing the address.
- **Client.java**: Entity representing the client.
- **AddressRepository.java**: Repository interface for address operations.
- **ClientRepository.java**: Repository interface for client operations.
- **ClientService.java**: Service interface for client operations.
- **ViaCepService.java**: Service interface for accessing the ViaCep API.
- **ClientServiceImpl.java**: Implementation of ClientService.
- **ApiError.java**: Class for handling API errors.
- **ApiExceptionHandler.java**: Global exception handler for the API.
- **ClientNotFoundException.java**: Custom exception for client not found cases.
- **ApiProjectApplication.java**: Main class for bootstrapping the Spring Boot application.

## Database DER Diagram
```
+----------------------+
|       Client         |
+----------------------+
| - id: Long           |
| - name: String       |
| - address_cep: String|
+----------------------+
            |
            | ManyToOne
            |
+----------------------+
|      Address         |
+----------------------+
| - cep: String        |
| - logradouro: String |
| - complemento: String|
| - unidade: String    |
| - bairro: String     |
| - localidade: String |
| - uf: String         |
| - ibge: String       |
| - gia: String        |
| - ddd: String        |
| - siafi: String      |
+----------------------+
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven
- An IDE of your choice

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/postal_code_api.git
   cd postal_code_api
   ```

2. Install the dependencies:
   ```bash
   mvn install
   ```

### Running the Application
1. Run the application:
   ```bash
   mvn spring-boot:run
   ```

2. The application will be available at `http://localhost:8080`.

## Usage

### Endpoints
- **GET /clients**: Retrieve all clients.
- **GET /clients/{id}**: Retrieve a client by ID.
- **POST /clients**: Create a new client.
- **PUT /clients/{id}**: Update a client by ID.
- **DELETE /clients/{id}**: Delete a client by ID.

## Technologies Used
- Spring Boot
- Spring Data JPA
- Spring Cloud OpenFeign
- H2 Database
- Thymeleaf
- jQuery
- Lombok

### Explanation
- Overview: Gives an overview of the project.
- **Project Structure**: Explains the structure of the project, listing packages and main classes.
- Database ER Diagram: Presents the DER of the database.
- Getting Started: Instructions for getting started with the project, including prerequisites, installation and execution.
- **Usage**: Lists the API endpoints.
- **Technologies Used**: Lists the technologies used in the project.

This README should help any developer to understand, configure and use the project efficiently.

## Author

Developed by Lucas Santos

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.