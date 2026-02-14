# Student Management System

A Java-based Student Management System built using JDBC and MySQL with layered architecture (Controller, Service, DAO).

---

## Features

- Add new student
- View all students
- Update student details
- Delete student
- Persistent data storage using MySQL database
- Clean layered architecture (Controller → Service → DAO → Database)

---

## Technologies Used

- Java
- JDBC
- MySQL
- IntelliJ IDEA
- Git & GitHub

---

## Project Architecture

The project follows a layered architecture:

- **Controller Layer** → Handles user interaction
- **Service Layer** → Contains business logic
- **DAO Layer** → Handles database operations
- **Model Layer** → Represents Student entity
- **Util Layer** → Manages database connection

This structure ensures separation of concerns and better maintainability.

---

## Database Configuration

Before running the project:

1. Install MySQL
2. Create a database (e.g., `student_db`)
3. Create a `student` table with appropriate columns:
   - id (INT, Primary Key)
   - name (VARCHAR)
   - marks (DOUBLE)

4. Update database credentials in the connection utility class.

---

## How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Configure MySQL database
4. Run `Main.java`

---

## Future Improvements

- Add input validation
- Convert into Spring Boot REST API
- Add GUI (JavaFX / Web Frontend)
- Add logging & exception handling improvements
