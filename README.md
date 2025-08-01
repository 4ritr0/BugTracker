# 🐞 Bug Management System

A modern, full-stack **MVC-based Bug Management System** built with Spring Boot, MySQL, and a beautiful HTML/CSS/JS frontend. This project enables efficient bug tracking and user management for software teams, following the Model-View-Controller (MVC) architecture.

---

## 🚀 Features

- **Role-based Dashboards**: Separate dashboards for Admin, Project Manager, Developer, and Tester.
- **User Management**: Admin can add/delete Project Managers, Developers, and Testers.
- **Bug Lifecycle Management**: Create, assign, update, and track bugs through various statuses (Open, In Progress, Resolved, Closed).
- **Project Assignment**: Assign bugs to developers/testers and manage project teams.
- **Authentication**: Secure login for all user roles.
- **Responsive UI**: Clean, modern, and responsive design for all screens.
- **RESTful APIs**: Backend exposes REST endpoints for all major operations.
- **Persistent Storage**: All data stored in a MySQL database using JPA/Hibernate.

---

## 🏗️ Tech Stack

| Layer          | Technology                        |
| -------------- | --------------------------------- |
| **Frontend**   | HTML5, CSS3, JavaScript (Vanilla) |
| **Backend**    | Spring Boot (Java 17)             |
| **Database**   | MySQL                             |
| **ORM**        | Spring Data JPA (Hibernate)       |
| **Build Tool** | Maven                             |
| **Other**      | Lombok, RESTful APIs              |

---

## 🗂️ Project Structure (MVC)

```
├── src/
│   ├── main/
│   │   ├── java/com/example/bugtracker/
│   │   │   ├── controller/   # Controllers (C)
│   │   │   ├── model/        # Entities/Models (M)
│   │   │   ├── repository/   # Data Access Layer
│   │   │   └── service/      # Business Logic
│   │   └── resources/
│   │       ├── static/       # Views (V) - HTML, CSS, JS
│   │       └── application.properties
│   └── test/
│       └── ...
```

---

## 🖼️ MVC Architecture Flowchart

```mermaid
flowchart TD
    A[User (Browser)] -->|HTTP Request| B[View (HTML/CSS/JS)]
    B -->|Form/API Call| C[Controller (Spring Boot)]
    C -->|Service Call| D[Service Layer]
    D -->|DB Access| E[Repository (JPA)]
    E -->|CRUD| F[(MySQL DB)]
    D -->|Return Data| C
    C -->|Render/Redirect| B
    B -->|Display| A
```

---

## ✨ Implemented Features (Details)

### 👤 User Management

- **Admin** can add, view, and delete Project Managers, Developers, and Testers.
- **Role-based authentication** ensures only authorized access to dashboards.

### 🐛 Bug Tracking

- **Create Bug**: PMs/Testers can create new bugs.
- **Assign Bug**: PMs can assign bugs to Developers or Testers.
- **Update Status**: Developers/Testers can update bug status (Open, In Progress, Resolved, Closed).
- **View Bugs**: All roles can view bugs relevant to them.

### 📊 Dashboards

- **Admin Dashboard**: Manage all users.
- **PM Dashboard**: Manage projects, assign bugs, view team.
- **Developer Dashboard**: View assigned bugs, update status.
- **Tester Dashboard**: Report bugs, verify fixes.

### 🔒 Security

- **Login system** for all roles.
- **Session management** for secure access.

### 📡 RESTful API

- All CRUD operations for users and bugs are exposed as REST endpoints.

---

## 🛠️ How to Run

1. **Clone the repository**
   ```sh
   git clone <repo-url>
   ```
2. **Configure MySQL** in `application.properties`.
3. **Build & Run**
   ```sh
   ./mvnw spring-boot:run
   ```
4. **Access the app** at [http://localhost:8080](http://localhost:8080)

---

## 📬 Contributions

Feel free to fork, open issues, or submit PRs! For major changes, please open an issue first to discuss what you would like to change.

---

## 📄 License

This project is for educational/demo purposes.
