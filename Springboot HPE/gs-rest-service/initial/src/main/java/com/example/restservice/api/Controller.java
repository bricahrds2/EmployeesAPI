package com.example.restservice.api;


import com.example.restservice.services.EmployeesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.restservice.api.Employee;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RequestMapping("/employees")
@RestController
public class Controller {

    private EmployeesDAO employeesDAO;
    @Autowired
    public Controller(EmployeesDAO employeesDAO){
        this.employeesDAO = employeesDAO;
    }

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<Employees> getEmployees(){
        return ResponseEntity.ok(employeesDAO.getAllEmployees());
    }

    @PostMapping("/")
    public ResponseEntity<Object>
    addEmployee(@RequestBody Employee employee) {
        if (employee == null) {
            return ResponseEntity.badRequest().body("Invalid employee data");
        }
        // Generate ID for the new employee
        Integer id = employeesDAO.getAllEmployees()
                .getEmployeeList().size() + 1;
        employee.setID(id);


        // Add employee to the list
            employeesDAO.addEmployee(employee);


        // Build location URI for the new employee
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getID())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
