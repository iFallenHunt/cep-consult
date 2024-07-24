# Projeto de API de Código Postal

## Índice

- [Visão Geral](#visão-geral)
- [Estrutura do Projeto](#estrutura-do-projeto)
    - [Pacotes](#pacotes)
    - [Classes Principais](#classes-principais)
- [Diagrama DER do Banco de Dados](#diagrama-der-do-banco-de-dados)
- [Começando](#começando)
    - [Pré-requisitos](#pré-requisitos)
    - [Instalação](#instalação)
    - [Executando a Aplicação](#executando-a-aplicação)
- [Uso](#uso)
    - [Endpoints](#endpoints)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)

## Visão Geral

O Projeto de API de Código Postal é uma aplicação Spring Boot que fornece uma API RESTful para gerenciar clientes e seus
endereços. Ele integra com o serviço ViaCep para recuperar detalhes de endereço com base em códigos postais (CEPs).

## Estrutura do Projeto

### Pacotes

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

### Classes Principais

- **ClientRestController.java**: Define os endpoints REST para operações com clientes.
- **Address.java**: Entidade que representa o endereço.
- **Client.java**: Entidade que representa o cliente.
- **AddressRepository.java**: Interface de repositório para operações com endereços.
- **ClientRepository.java**: Interface de repositório para operações com clientes.
- **ClientService.java**: Interface de serviço para operações com clientes.
- **ViaCepService.java**: Interface de serviço para acessar a API ViaCep.
- **ClientServiceImpl.java**: Implementação do ClientService.
- **ApiError.java**: Classe para tratamento de erros da API.
- **ApiExceptionHandler.java**: Manipulador global de exceções para a API.
- **ClientNotFoundException.java**: Exceção personalizada para casos de cliente não encontrado.
- **ApiProjectApplication.java**: Classe principal para inicializar a aplicação Spring Boot.

## Diagrama DER do Banco de Dados

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

## Começando

### Pré-requisitos

- Java 17 ou superior
- Maven
- Um IDE de sua escolha

### Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/yourusername/postal_code_api.git
   cd postal_code_api
   ```

2. Instale as dependências:
   ```bash
   mvn install
   ```

### Executando a Aplicação

1. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

2. A aplicação estará disponível em `http://localhost:8080`.

## Uso

### Endpoints

- **GET /clients**: Recupera todos os clientes.
- **GET /clients/{id}**: Recupera um cliente pelo ID.
- **POST /clients**: Cria um novo cliente.
- **PUT /clients/{id}**: Atualiza um cliente pelo ID.
- **DELETE /clients/{id}**: Deleta um cliente pelo ID.

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- Spring Cloud OpenFeign
- H2 Database
- Thymeleaf
- jQuery
- Lombok

### Explicação

- **Visão Geral**: Dá uma visão geral do projeto.
- **Estrutura do Projeto**: Explica a estrutura do projeto, listando pacotes e classes principais.
- **Diagrama DER do Banco de Dados**: Apresenta o DER do banco de dados.
- **Começando**: Instruções para começar a usar o projeto, incluindo pré-requisitos, instalação e execução.
- **Uso**: Lista os endpoints da API.
- **Tecnologias Utilizadas**: Lista as tecnologias utilizadas no projeto.

Este README deve ajudar qualquer desenvolvedor a entender, configurar e usar o projeto de maneira eficiente.

## Autor

Desenvolvido por Lucas Santos

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.
