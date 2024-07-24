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
- [API Visualization](#api-visualization)
    - [Using Swagger](#using-swagger)
    - [Using the Frontend](#using-the-frontend)
- [Technologies Used](#technologies-used)

## Overview

The Postal Code API Project is a Spring Boot application that provides a RESTful API for managing clients and their
addresses. It integrates with the ViaCep service to retrieve address details based on postal codes (CEPs).

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

## API Visualization

### Using Swagger

Swagger is a tool that allows you to view and interact with the API in an interactive way. To access the API
documentation via Swagger, follow these steps:

1. **Ensure the application is running**: The application should be running locally at `http://localhost:8080`.

2. **Access Swagger UI**: Open your browser and go to `http://localhost:8080/swagger-ui.html`.

    - In the Swagger UI interface, you will see a list of all available endpoints in the API.

    - You can test the endpoints directly through the interface by clicking "Try it out" and filling in the required
      parameters.

    - The documentation is automatically generated based on annotations made in the API controller classes.

### Using the Frontend

The frontend provides a graphical interface to interact with the API. To use the frontend, follow these steps:

1. **Ensure the application is running**: The application should be running locally at `http://localhost:8080`.

2. **Access the frontend**: Open your browser and go to `http://localhost:8080/web/clients`.

    - On the homepage, you will see a list of registered clients and a form to add new clients.
    - **Add Client**: Fill out the form with the client's information, including name and ZIP code (can be entered in
      the format `13026099` or `13026-099`).
        - Click the "Save" button to add the client to the list.
    - **View Information**: After adding a client, you can click the client's name in the list to view their details.
    - **Search for Client**: Use the search bar to filter clients by name. As you type, the list will update to show
      only clients that match the search text.
    - **Update and Delete**: You can update and delete clients directly in the client list by clicking the appropriate
      buttons.

These features provide an easy and intuitive way to interact with the API and manage your data.

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
- Getting Started: Instructions for getting started with the project, including prerequisites, installation and
  execution.
- **Usage**: Lists the API endpoints.
- **Technologies Used**: Lists the technologies used in the project.

This README should help any developer to understand, configure and use the project efficiently.

## Author

Developed by Lucas Santos

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.