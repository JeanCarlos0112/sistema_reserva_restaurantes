# 🍽️ Restaurant Reservation System (API)

![Project Status](https://img.shields.io/badge/STATUS-IN_DEVELOPMENT-yellow?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)

---

## 📖 About the Project

This is a personal project developed to serve a **medium-sized restaurant**. The system is designed as a web service architecture.

Currently, the project is in the **Back-end construction phase**, focusing on building a robust API using **Java Spring Boot** and **JPA** to handle business rules and data persistence.

**Future Roadmap:**
The Front-end interface will be developed subsequently using **React** and **Tailwind CSS**, which will consume this API.

---

## 🔎 Technical Details

This API is built following RESTful principles and the MVC architecture.

* **Back-end:** Java Spring Boot
* **Database:** JPA (Java Persistence API) / Hibernate
* **Build Tool:** Maven

The application implements the **[CRUD](https://developer.mozilla.org/en-US/docs/Glossary/CRUD)** structure (Create, Read, Update, Delete) to manage restaurant resources (reservations, tables, customers).

---

## 🗃️ Prerequisites

Before running this project, ensure you have the following installed:

* **[Java JDK 17](https://www.oracle.com/java/technologies/downloads/)** (or higher)
* **[Maven](https://maven.apache.org/)** (Optional if using the included `mvnw` wrapper)
* **IDE:** IntelliJ IDEA, Eclipse, or VS Code (with Java Extension Pack)

---

## 🗣️ How to Use

### 1. Clone the Repository
Open your terminal and run:
```bash
git clone [https://github.com/JeanCarlos0112/repository-name.git](https://github.com/JeanCarlos0112/repository-name.git)
cd repository-name
```

### 2. Configure the Database
Before running, check the src/main/resources/application.properties file. You need to configure your database connection (PostgreSQL, MySQL, or H2 for testing).

Example configuration:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the Application
You can execute the project using the Maven Wrapper command in the terminal:

On Windows:
```bash
mvnw spring-boot:run
```
On Linux/macOS:
```bash
./mvnw spring-boot:run
```

### 4. Access the Endpoints
Once the server starts, the API will generally be available at:
```bash
http://localhost:8080
```

---

## 🚧 Project Phases
- [x] Phase 1: Database Modeling & JPA Entities

- [ ] Phase 2: API Logic (Controllers & Services)

- [ ] Phase 3: Validations & Security

- [ ] Phase 4: Front-end Integration (React + Tailwind)

## 📜 License
This project is licensed under the [MIT License](https://github.com/JeanCarlos0112/sistema_reserva_restaurantes/blob/main/LICENSE)
