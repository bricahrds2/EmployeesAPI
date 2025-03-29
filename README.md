🌟 Employees API - Spring Boot, Postman & Unit Testing

Welcome to the Employees API, a Spring Boot-powered RESTful service that manages employees. This API supports CRUD operations and is tested using JUnit & MockMvc. Postman is used for manual testing and API documentation.

📌 Features

✅ Spring Boot - RESTful API Development✅ CRUD Operations - Create, Read, Update, Delete Employees✅ Postman - API Testing & Collection✅ JUnit & MockMvc - Unit & Integration Testing✅ JSON Responses - Clean and structured data format✅ Spring Data JPA - Database Integration

📦 Project Structure

📂 employees-api/
├── 📂 src/main/java/com/example/restservice/
│   ├── 📂 controller/    # REST Controllers
│   ├── 📂 service/       # Business Logic
│   ├── 📂 repository/    # Data Access Layer
│   ├── 📂 model/         # Entity Classes
│   ├── 📂 exceptions/    # Custom Exceptions
├── 📂 src/test/java/com/example/restservice/  # Unit Tests
├── 📄 pom.xml           # Maven Dependencies
└── 📄 README.md         # API Documentation

🚀 Getting Started

🔧 Prerequisites

Java 17+

Spring Boot 3.x

Maven

Postman

H2 Database (In-Memory) / MySQL

🔨 Installation & Setup

1️⃣ Clone the repository

git clone https://github.com/your-username/employees-api.git
cd employees-api

2️⃣ Build & Run the Project

mvn spring-boot:run

3️⃣ Access the API

Open Postman and import employees-api.postman_collection.json

Base URL: http://localhost:8080/employees

🔥 API Endpoints

📍 Employee CRUD Operations

Method

Endpoint

Description

GET

/employees

Get all employees

GET

/employees/{id}

Get an employee by ID

POST

/employees

Add a new employee

PUT

/employees/{id}

Update an existing employee

DELETE

/employees/{id}

Remove an employee

Example POST Request (Add Employee):

{
  "fname": "John",
  "lname": "Doe",
  "title": "Software Engineer",
  "email": "john.doe@example.com"
}

🛠️ Unit Testing (JUnit + MockMvc)

📝 Sample Test Case

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployees() throws Exception {
        List<Employee> employees = List.of(new Employee(1, "Alice", "Smith", "Manager", "alice@example.com"));
        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.size()").value(1))
            .andExpect(jsonPath("$[0].fname").value("Alice"));
    }
}

✅ Run Tests:

mvn test

📬 Postman Collection

📥 Download Postman Collection: employees-api.postman_collection.json

1️⃣ Import into Postman → File → Import → Select JSON2️⃣ Set Environment → BASE_URL = http://localhost:8080/employees3️⃣ Run API Requests

🎯 Future Enhancements

🔹 Add JWT Authentication & Security🔹 Implement Docker & Kubernetes🔹 CI/CD Integration (GitHub Actions)

🏆 Contributors

👤 Your Name - GitHub

📧 Have questions? Contact us at support@yourapi.com

⭐ Show Some Love!

If you found this project useful, please star ⭐ the repository to show support! 😊
