# 🚀 Task Management System

<p align="center">
  <strong>A Full-Stack Task Management Application</strong>
  <br />
  Built with React, Spring Boot, Java, and MySQL.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring_Boot-Backend-6DB33F?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/React-Frontend-61DAFB?style=for-the-badge&logo=react" />
  <img src="https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql" />
  <img src="https://img.shields.io/badge/Status-In_Development-blue?style=for-the-badge" />
</p>

---

## 📌 About the Project

Task Management System is a full-stack web application designed to help users organize tasks, track progress, and manage daily activities efficiently.

This project is being developed to strengthen my practical knowledge of **Java Full Stack Development**, including REST APIs, React, Spring Boot, database integration, and frontend development.

## ✨ Features

### Frontend — React

- [x] Dashboard UI
- [x] Display task list
- [x] Add new tasks
- [x] Mark tasks as completed
- [x] Undo task completion
- [x] Delete tasks
- [x] Dynamic task statistics
- [ ] Edit existing tasks
- [ ] Connect frontend to backend APIs
- [ ] Persistent task storage through MySQL

### Backend — Spring Boot

- [x] REST API development
- [x] Create tasks
- [x] Retrieve all tasks
- [x] Retrieve task by ID
- [x] Update tasks
- [x] Delete tasks
- [x] Spring Data JPA integration
- [x] MySQL database connection

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Backend programming |
| Spring Boot | Backend framework |
| Spring Data JPA | Database operations |
| Hibernate | ORM |
| MySQL | Database |
| React.js | Frontend |
| JavaScript | Frontend logic |
| HTML5 & CSS3 | UI development |
| Maven | Dependency management |
| Git & GitHub | Version control |

## 📂 Project Structure

```text
taskmanager/
│
├── src/
│   └── main/
│       ├── java/com/sujal/taskmanager/
│       │   ├── controller/
│       │   │   └── TaskController.java
│       │   ├── entity/
│       │   │   └── Task.java
│       │   ├── repository/
│       │   │   └── TaskRepository.java
│       │   └── service/
│       │       └── TaskService.java
│       │
│       └── resources/
│           └── application.properties
│
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── Header.jsx
│   │   │   ├── StatsCard.jsx
│   │   │   └── TaskCard.jsx
│   │   ├── App.jsx
│   │   ├── App.css
│   │   └── index.css
│   └── package.json
│
├── pom.xml
└── README.md
```

## ⚙️ Getting Started

### Prerequisites

Make sure you have installed:

- Java 17 or later
- Node.js and npm
- MySQL Server
- Git
- VS Code or IntelliJ IDEA

### 1. Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
cd taskmanager
```

### 2. Configure MySQL

Create the database:

```sql
CREATE DATABASE taskmanager_db;
```

Configure your database connection in:

`src/main/resources/application.properties`

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager_db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

Set `DB_USERNAME` and `DB_PASSWORD` as environment variables before starting the backend.

### 3. Run the Spring Boot Backend

From the project root:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Backend URL:

`http://localhost:8080`

### 4. Run the React Frontend

Open another terminal:

```bash
cd frontend
npm install
npm run dev
```

Frontend URL:

`http://localhost:5173`

## 🔗 REST API Endpoints

Base URL: `http://localhost:8080/api/tasks`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Retrieve all tasks |
| GET | `/api/tasks/{id}` | Retrieve task by ID |
| POST | `/api/tasks` | Create a task |
| PUT | `/api/tasks/{id}` | Update a task |
| DELETE | `/api/tasks/{id}` | Delete a task |

### Example Task JSON

```json
{
  "title": "Learn Spring Boot",
  "description": "Build REST APIs using Spring Boot",
  "completed": false
}
```

## 🗺️ Development Roadmap

Track the project's development progress:

- [x] Phase 1 — Spring Boot project setup
- [x] Phase 2 — MySQL database configuration
- [x] Phase 3 — Task entity and repository
- [x] Phase 4 — REST
