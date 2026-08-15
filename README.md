#  JIRA-Style Collaborative Project Management System

A backend-based **JIRA-style Collaborative Project Management System** built using **Java and Spring Boot**.

This project provides a structured backend for managing software development projects, project boards, tickets, users, and comments. It follows a clean **layered architecture** using **Controller → Service → Repository → Entity**.

---

##  Project Overview

The JIRA-Style Project Management System is designed to help development teams organize and track their work efficiently.

The system allows users to create projects, manage project boards, create and assign tickets, track ticket progress, add comments, and manage project members.

###  Main Objectives

* Manage multiple software development projects
* Organize work using project boards
* Create and assign tickets to users
* Track ticket status and priority
* Add comments to tickets
* Manage project members and users
* Maintain relationships between projects, boards, tickets, users, and comments

---

##  Features

###  User Management

* Create users
* Manage user information
* Assign users to projects
* Assign tickets to users
* Associate users with ticket comments

###  Project Management

* Create projects
* Update project information
* Manage project members
* Associate boards with projects
* Associate tickets with projects

###  Board Management

* Create project boards
* Associate boards with projects
* Organize project tickets
* Manage tickets within boards

###  Ticket Management

* Create tickets
* Update ticket details
* Assign tickets to users
* Set ticket priority
* Set ticket type
* Track ticket status
* Associate tickets with projects
* Associate tickets with boards

###  Comment Management

* Add comments to tickets
* Associate comments with users
* Associate comments with tickets
* Maintain ticket discussion history

###  Ticket Tracking

Tickets can be organized and tracked using different:

* **Ticket Types**
* **Ticket Priorities**
* **Ticket Statuses**

This helps teams understand the current state and importance of each task.

---

##  Project Architecture

The application follows a **layered backend architecture**:

```text
                    Client / Postman
                           |
                           ↓
                  ┌────────────────┐
                  │   Controller   │
                  └───────┬────────┘
                          ↓
                  ┌────────────────┐
                  │    Service     │
                  └───────┬────────┘
                          ↓
                  ┌────────────────┐
                  │   Repository   │
                  └───────┬────────┘
                          ↓
                  ┌────────────────┐
                  │     Entity     │
                  └───────┬────────┘
                          ↓
                       Database
```

### 🔹 Controller Layer

Handles incoming HTTP requests and exposes REST APIs for the application.

### 🔹 Service Layer

Contains the application's business logic and coordinates operations between controllers and repositories.

### 🔹 Repository Layer

Handles database operations using Spring Data JPA repositories.

### 🔹 Entity Layer

Contains the application's database entities and their relationships.

---

## 🔗 Main Entity Relationships

The system maintains relationships between the major entities:

```text
                 ┌─────────────┐
                 │    User     │
                 └──────┬──────┘
                        │
             ┌──────────┴──────────┐
             ↓                     ↓
        Project Members       Assigned Tickets
             │                     │
             ↓                     ↓
        ┌───────────┐        ┌───────────┐
        │  Project  │───────→│  Ticket   │
        └─────┬─────┘        └─────┬─────┘
              │                    │
              ↓                    ↓
        ┌───────────┐        ┌───────────┐
        │   Board   │        │  Comment  │
        └─────┬─────┘        └─────┬─────┘
              │                    │
              └────── Tickets ─────┘
```

---

## 🛠️ Technologies Used

| Technology                 | Purpose                  |
| ---------------------------| -------------------------|
| ☕ Java                    | Backend Programming      |
| 🌱 Spring Boot             | Backend Framework        |
| 🌐 Spring Web              | REST API Development     |
| 🗄️ Spring Data JPA         | Database Operations      |
| 🔗 Hibernate               | ORM / Entity Mapping     |
| 🛢️ MySQL / Database        | Data Storage             |
| 📮 Postman                 | API Testing              |
| 🔧 Maven                   | Dependency Management    |
| 💻 Git & GitHub            | Version Control          |

> Update the database name above if your project uses PostgreSQL or another database.

---

##  Project Structure

```text
src
└── main
    └── java
        └── com.example.Jira
            │
            ├── Controller
            │   ├── UserController
            │   ├── ProjectController
            │   ├── BoardController
            │   ├── TicketController
            │   └── CommentController
            │
            ├── Service
            │   ├── UserService
            │   ├── ProjectService
            │   ├── BoardService
            │   ├── TicketService
            │   └── CommentService
            │
            ├── Repository
            │   ├── UserRepository
            │   ├── ProjectRepository
            │   ├── BoardRepository
            │   ├── TicketRepository
            │   └── CommentRepository
            │
            └── Entity
                ├── User
                ├── Project
                ├── Board
                ├── Ticket
                └── Comment
```

---

##  Application Workflow

A typical workflow of the application is:

```text
1. Create User
       ↓
2. Create Project
       ↓
3. Add Project Members
       ↓
4. Create Project Board
       ↓
5. Create Ticket
       ↓
6. Assign Ticket to User
       ↓
7. Set Type / Priority / Status
       ↓
8. Add Comments
       ↓
9. Track Ticket Progress
```

---

##  Ticket Management

Each ticket can contain information such as:

```text
Ticket
 ├── Title
 ├── Description
 ├── Type
 ├── Priority
 ├── Status
 ├── Project
 ├── Board
 ├── Assigned User
 └── Comments
```

### Example Ticket

```text
Title       : Implement Login API
Type        : TASK
Priority    : HIGH
Status      : IN_PROGRESS
Project     : JIRA Project
Board       : Development
Assigned To : Developer
```

---

##  Example Ticket Status Flow

```text
┌─────────┐
│  TODO   │
└────┬────┘
     ↓
┌─────────────┐
│ IN PROGRESS │
└──────┬──────┘
       ↓
┌────────────┐
│   REVIEW   │
└──────┬─────┘
       ↓
┌───────────┐
│   DONE    │
└───────────┘
```

This allows development teams to track the progress of their tasks.

---

##  REST API

The backend exposes REST APIs for different resources.

###  User APIs

```text
POST    /users
GET     /users
GET     /users/{id}
PUT     /users/{id}
DELETE  /users/{id}
```

###  Project APIs

```text
POST    /projects
GET     /projects
GET     /projects/{id}
PUT     /projects/{id}
DELETE  /projects/{id}
```

###  Board APIs

```text
POST    /boards
GET     /boards
GET     /boards/{id}
PUT     /boards/{id}
DELETE  /boards/{id}
```

###  Ticket APIs

```text
POST    /tickets
GET     /tickets
GET     /tickets/{id}
PUT     /tickets/{id}
DELETE  /tickets/{id}
```

###  Comment APIs

```text
POST    /comments
GET     /comments
GET     /comments/{id}
PUT     /comments/{id}
DELETE  /comments/{id}
```

> Replace these endpoint paths with your actual controller mappings if they are different.

---

##  API Testing

The APIs can be tested using **Postman**.

Example request:

```http
POST /tickets
Content-Type: application/json
```

Example JSON:

```json
{
    "title": "Implement Login API",
    "description": "Create login functionality",
    "priority": "HIGH",
    "type": "TASK",
    "status": "TODO"
}
```

---

##  How to Run the Project

### 1️ Clone the Repository

```bash
git clone <https://github.com/Priyank1922/JIRA-Style-Collaborative-Project-Management-System>
```

### 2️ Open the Project

Open the project in:

* Eclipse
* IntelliJ IDEA
* VS Code

### 3️ Configure Database

Update your database configuration in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_name
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4️ Build the Project

Using Maven:

```bash
mvn clean install
```

### 5️ Run the Application

Run the Spring Boot main class:

```text
JiraApplication.java
```

Or use:

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

---

##  Testing with Postman

After starting the application:

1. Open Postman
2. Select the required HTTP method
3. Enter the API endpoint
4. Add JSON data where required
5. Send the request
6. Verify the API response

---



##  Learning Outcomes

Through this project, the following concepts are demonstrated:

* Java backend development
* Spring Boot application development
* REST API development
* Layered architecture
* Spring Data JPA
* Hibernate ORM
* Entity relationships
* CRUD operations
* Database integration
* API testing with Postman
* Maven project management
* Git and GitHub workflow

---

##  Project Vision

The goal of this project is to build a scalable backend similar to a real-world project management platform where development teams can manage their **projects, boards, tickets, users, and discussions** from a single system.

The architecture is designed so that additional features such as authentication, authorization, notifications, dashboards, and microservices can be added in the future.

---

##  Author

**Priyank Mehta**


---

⭐ If you find this project useful, consider giving the repository a star!
