🎯 Project Description
The Digital Library Management System is a Spring Boot REST API that allows librarians to manage book records effectively. It provides functionalities to:

Add new books.

View all books.

Search for books by ID or title.

Update book details.

Delete books from the system.

🛠️ Technology Stack
Backend: Java, Spring Boot, Spring Data JPA

Database: MySQL

Validation: Jakarta Validation

Build Tool: Maven

Version Control: Git and GitHub

Email Configuration: Gmail SMTP

📂 Project Structure
bash
Copy
Edit
/DigitalLibrary
├── /src
│   ├── /main
│   │   ├── /java/com/project/DigitalLibrary
│   │   │   ├── /controller
│   │   │   │   └── BookController.java
│   │   │   ├── /dao
│   │   │   │   └── BookDao.java
│   │   │   ├── /dto
│   │   │   │   └── Book.java
│   │   │   ├── /repo
│   │   │   │   └── BookRepository.java
│   │   │   ├── /service
│   │   │   │   └── BookService.java
│   │   │   └── DigitalLibraryApplication.java
│   │   └── /resources
│   │       ├── application.properties
│   │       └── data.sql (optional)
└── /target
📥 Setup and Installation
✅ Step 1: Clone the Repository
bash
Copy
Edit
git clone https://github.com/your-username/DigitalLibrary.git
bash
Copy
Edit
cd DigitalLibrary
✅ Step 2: Configure MySQL Database
Open src/main/resources/application.properties.

Update the database properties:

ini
Copy
Edit
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/agro?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root

# Hibernate Properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Email Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-email-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
✅ Step 3: Create Database in MySQL
sql
Copy
Edit
CREATE DATABASE agro;
▶️ Step 4: Run the Application
Open the project in IntelliJ IDEA or Eclipse.

Run DigitalLibraryApplication.java as a Spring Boot application.

Verify that the application is running at:

arduino
Copy
Edit
http://localhost:8080
📡 API Endpoints
Method	URL	Description
POST	/library	Add a new book
GET	/library	Get all books
GET	/library/{id}	Get a book by ID
GET	/library/title?title=	Search books by title
PUT	/library/{id}	Update book details
DELETE	/library/{id}	Delete a book by ID
📝 Sample API Requests
➡️ 1. Add a New Book
json
Copy
Edit
POST /library
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "genre": "Programming",
  "availability": "Available"
}
➡️ 2. Get All Books
bash
Copy
Edit
GET /library
➡️ 3. Get a Book by ID
bash
Copy
Edit
GET /library/1
➡️ 4. Search Books by Title
bash
Copy
Edit
GET /library/title?title=Java
➡️ 5. Update Book Details
json
Copy
Edit
PUT /library/1
{
  "title": "Java Concurrency",
  "author": "Doug Lea",
  "genre": "Programming",
  "availability": "Checked Out"
}
➡️ 6. Delete a Book by ID
bash
Copy
Edit
DELETE /library/1
🚨 Error Handling
Status Code	Message
400	Invalid request data
404	Book not found
500	Internal server error
