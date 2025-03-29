# 🌟 Employees API 🚀  
*A Spring Boot REST API for managing employees, tested with JUnit and Postman*

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.5-green?style=for-the-badge&logo=spring-boot)
![JUnit](https://img.shields.io/badge/JUnit-5.8.2-blue?style=for-the-badge&logo=java)
![Postman](https://img.shields.io/badge/Tested%20With-Postman-orange?style=for-the-badge&logo=postman)

---

## 📌 Features  
✅ Create, Read, Update, and Delete (CRUD) Employee Records  
✅ REST API with JSON Requests & Responses  
✅ **Unit Testing** using **JUnit & Mockito**  
✅ **Integration Testing** using **MockMvc**  
✅ Tested via **Postman**  

---

## 📁 Project Structure  

```
employees-api/
│── src/main/java/com/example/restservice
│   ├── api/
│   │   ├── EmployeesController.java  # REST Controller
│   │   ├── Employees.java            # Employees Model
│   │   ├── Employee.java             # Employee Entity
│   │   ├── EmployeesDAO.java         # Data Access Layer
│   ├── services/
│   │   ├── EmployeesService.java     # Business Logic Layer
│   ├── EmployeesApiApplication.java  # Main Spring Boot Application
│
│── src/test/java/com/example/restservice
│   ├── ControllerTest.java           # JUnit & Mockito Tests
│
│── postman/                          # Postman Collection
│── README.md                         # Documentation
│── pom.xml                            # Dependencies (Maven)
```

---

## 🔧 Installation  

### **1️⃣ Clone the Repository**  
```bash
git clone https://github.com/yourusername/employees-api.git
cd employees-api
```

### **2️⃣ Install Dependencies**  
Ensure you have **Java 17+** and **Maven** installed.  
```bash
mvn clean install
```

### **3️⃣ Run the Application**  
```bash
mvn spring-boot:run
```

---

## 🛠️ API Endpoints  

### 📌 **Get All Employees**  
**Request:**  
```http
GET /employees
```
✅ **Response (200 OK)**  
```json
{
  "employeeList": [
    {
      "id": 1,
      "fname": "John",
      "lname": "Doe",
      "title": "Manager",
      "email": "johndoe@example.com"
    },
    {
      "id": 2,
      "fname": "Jane",
      "lname": "Smith",
      "title": "CEO",
      "email": "janesmith@example.com"
    }
  ]
}
```

---

### 📌 **Get Employee by ID**  
**Request:**  
```http
GET /employees/1
```
✅ **Response (200 OK)**  
```json
{
  "id": 1,
  "fname": "John",
  "lname": "Doe",
  "title": "Manager",
  "email": "johndoe@example.com"
}
```
❌ **Response (404 Not Found)**
```json
{
  "error": "Employee not found"
}
```

---

### 📌 **Add a New Employee**  
**Request:**  
```http
POST /employees
Content-Type: application/json
```
**Body:**  
```json
{
  "fname": "Kevin",
  "lname": "Cruyff",
  "title": "CTO",
  "email": "kevin.cruyff@example.com"
}
```
✅ **Response (201 Created)**  
```json
{
  "id": 3,
  "fname": "Kevin",
  "lname": "Cruyff",
  "title": "CTO",
  "email": "kevin.cruyff@example.com"
}
```

---

## 🧪 Running Tests  

### **1️⃣ Run All Tests**  
```bash
mvn test
```

### **2️⃣ Controller Unit Test (JUnit & Mockito)**  
```java
@Test
public void getAllEmployeesTest() throws Exception {
    when(employeesDAO.getAllEmployees()).thenReturn(mockEmployees);

    mockMvc.perform(get("/employees")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.employeeList.length()").value(mockEmployeeList.size()));
}
```

---

## 📬 Postman Collection  
📥 **[Download Postman Collection](postman/employees_api.postman_collection.json)**  
💡 Import the JSON file into **Postman** and test all endpoints easily!

---

## 🛠️ Technologies Used  
- **Spring Boot** (REST API)  
- **Maven** (Build Tool)  
- **JUnit 5** & **Mockito** (Unit Testing)  
- **MockMvc** (Integration Testing)  
- **Postman** (API Testing)  
- **Lombok** (Simplify POJOs)  

---

## 🏆 Contributors  
👤 **[Brandon Richards]** – [GitHub Profile](https://github.com/bricahrds2)  

---

### 🚀 *Happy Coding! Build and Test Your API with Confidence!* 🎯
