# Bookstore Spring Boot Application

A RESTful web application for managing a bookstore built with Spring Boot 3.5.3 and Java 17.

## 📋 Description

This project is a comprehensive bookstore management system that provides REST APIs for managing authors and countries. It demonstrates modern Spring Boot development practices with JPA/Hibernate for data persistence, Oracle database integration, and clean architecture principles.

## 🚀 Features

- **Author Management**: Create, read, update, and delete author records
- **Country Reference Data**: Manage country information for author locations
- **RESTful API**: Full REST API with proper HTTP status codes
- **Database Integration**: Oracle Database support with JPA/Hibernate
- **Data Transfer Objects (DTOs)**: Clean separation between entities and API models
- **Service Layer**: Business logic encapsulation
- **Spring Boot Actuator**: Production-ready monitoring and management
- **Development Tools**: Hot reload with Spring Boot DevTools

## 🏗️ Architecture

The application follows a layered architecture pattern:

```
├── controller/          # REST API endpoints
├── entity/             # JPA entities and data models
│   ├── dao/           # Data Transfer Objects (DTOs)
│   └── service/       # Business logic services
├── repository/         # Data access layer (JPA repositories)
└── util/              # Utility classes and mappers
```

## 🛠️ Technology Stack

- **Java**: 17
- **Spring Boot**: 3.5.3
- **Spring Data JPA**: For database operations
- **Spring Web**: RESTful web services
- **Spring Boot Actuator**: Application monitoring
- **Oracle Database**: Primary database (with MySQL connector also available)
- **Lombok**: Reducing boilerplate code
- **Maven**: Dependency management and build tool

## 📦 Dependencies

Key dependencies include:
- `spring-boot-starter-web` - Web application support
- `spring-boot-starter-data-jpa` - JPA and Hibernate
- `spring-boot-starter-actuator` - Production monitoring
- `oracle-ojdbc11` - Oracle database driver
- `mysql-connector-j` - MySQL database connector
- `lombok` - Code generation
- `spring-boot-devtools` - Development tools

## 🔧 Configuration

The application uses environment variables for database configuration:

```yaml
Database Configuration:
- DB_HOST: Database host URL
- DB_PORT: Database port
- DB_NAME: Database name
- DB_USER: Database username
- DB_PASSWORD: Database password
```

**Server Configuration:**
- Default port: `8065`
- Application name: `bookstore-spring`

## 🚀 Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6+
- Oracle Database (or MySQL)

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd bookstore-spring
   ```

2. **Set up environment variables**
   ```bash
   export DB_HOST=jdbc:oracle:thin:@localhost
   export DB_PORT=1521
   export DB_NAME=bookstore
   export DB_USER=your_username
   export DB_PASSWORD=your_password
   ```

3. **Build the application**
   ```bash
   ./mvnw clean compile
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

   Or run the JAR file:
   ```bash
   ./mvnw package
   java -jar target/bookstore-app.jar
   ```

The application will start on `http://localhost:8065`

## 📚 API Endpoints

### Authors
- `GET /api/authors/` - Get all authors
- `GET /api/authors/{id}` - Get author by ID
- `POST /api/authors/` - Create a new author
- `DELETE /api/authors/{id}` - Delete an author

### Reference Data
Additional endpoints for managing reference data like countries.

## 🏃‍♂️ Running Tests

```bash
./mvnw test
```

## 🔍 Monitoring

The application includes Spring Boot Actuator for monitoring and management. Access the actuator endpoints at:
- Health check: `http://localhost:8065/actuator/health`
- Application info: `http://localhost:8065/actuator/info`

## 🏗️ Building for Production

To create a production-ready JAR:

```bash
./mvnw clean package -DskipTests
```

The executable JAR will be created as `target/bookstore-app.jar`

## 🤝 Development

### Project Structure
- **Entities**: JPA entities representing database tables
- **DTOs**: Data Transfer Objects for API communication
- **Services**: Business logic implementation
- **Controllers**: REST API endpoints
- **Repositories**: Data access interfaces

### Code Style
- Uses Lombok annotations to reduce boilerplate code
- Follows Spring Boot best practices
- Clean separation of concerns

## 📄 License

This project is licensed under the [License Name] - see the LICENSE file for details.

## 👨‍💻 Author

**Edvin** - *Initial work*

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Oracle for database support
- Lombok project for reducing boilerplate code
