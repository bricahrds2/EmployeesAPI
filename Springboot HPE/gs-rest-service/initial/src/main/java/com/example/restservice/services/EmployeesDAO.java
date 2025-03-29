package com.example.restservice.services;


import com.example.restservice.api.Employee;
import com.example.restservice.api.Employees;
import org.springframework.stereotype.Service;


@Service
public class EmployeesDAO {

    private Employees employees = new Employees();

    public EmployeesDAO() {
        employees.getEmployeeList().add(new Employee(01, "John", "Smith", "President", "mstern@myside.com"));
        employees.getEmployeeList()
                .add(new Employee(02, "Sam", "Stern", "COO","prem@gmail.com"));
        employees.getEmployeeList()
                .add(new Employee(03, "Bryce", "Young", "Vice President", "byoung@myside.com"));
        employees.getEmployeeList()
                .add(new Employee(04, "Tom", "Williams", "CFO", "twilliams@myside.com"));
        employees.getEmployeeList()
                .add(new Employee(05, "Jaden", "O'Neal", "CTO", "joneal@myside.com"));

    }

    // Retrieve all employees
    public Employees getAllEmployees() {
        return employees;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        employees.getEmployeeList().add(employee);
    }

    /*
    public List<Employee> getAllEmployees() {
        if (!employeeList.isEmpty())
            return employeeList;
        return null;


        for ( Employee emp : employeeList
             ) {
           return emp;
        }
         return null;
         */

}




